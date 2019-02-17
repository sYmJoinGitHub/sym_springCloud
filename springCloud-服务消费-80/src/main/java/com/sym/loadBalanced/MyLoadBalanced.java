package com.sym.loadBalanced;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义负载均衡策略：
 * 仍然以轮询为主，但是每个服务调用5次以后，换另外一个服务接着调用5次，以此类推
 *
 * Created by 沈燕明 on 2019/2/17.
 */
public class MyLoadBalanced extends AbstractLoadBalancerRule{

    // 计数器，1开始计数到5，然后重置为1
    AtomicInteger count = new AtomicInteger(1);
    // 所选服务的下标
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    /**
     * 真正的负载均衡逻辑
     * @param loadBalancer
     * @param key
     * @return
     */
    private Server choose(ILoadBalancer loadBalancer,Object key){

        Server server = null;

        if( loadBalancer == null ){
            return null;
        }
        // 可用服务列表
        List<Server> reachableServers = loadBalancer.getAllServers();
        int size = reachableServers.size();

        if( size == 0 ){
            throw new RuntimeException("没有可用的服务");
        }

        // 为了防止无线循环
        int temp = 0;

        while( server == null && temp++ < 10){
            server = reachableServers.get(getIndex(size));

            if( server == null ){
                Thread.yield();
                continue;
            }

            if( server.isAlive() && server.isReadyToServe() ){
                return server;
            }

        }

        if( temp >= 10 ){
            throw new RuntimeException("重试了"+temp+"次,仍未找到合适的服务提供方");
        }

        return server;
    }

    /**
     * 获取当前可用服务列表的下标
     * @param all 可用的服务数量
     * @return
     */
    private int getIndex(int all){
        for(;;){
            if( count.get() < 5 ){
                count.getAndIncrement();// count要+1
                return index.get();
            }
            // 如果count大于等于6，则需要切换下一个Server
            int currentVal = index.get();
            int nextVal = (currentVal+1)%all;
            if( index.compareAndSet(currentVal,nextVal) ){
                count.compareAndSet(count.get(),1);
                return index.get();
            }
        }
    }

    @Override
    public Server choose(Object key) {
        return this.choose(getLoadBalancer(),key);
    }
}
