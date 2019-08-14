package com.sym.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.sym.loadBalanced.MyLoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 消费方的配置类
 * <p>
 * Created by 沈燕明 on 2019/1/20.
 */
@Configuration
public class ConsumerConfig {

    /**
     * 注入RestTemplate并且开启负载均衡机制
     *
     * @return
     */
    @Bean
    @LoadBalanced //负载均衡注解
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 替换springCloud默认的轮询策略的负载均衡机制为随机策略
     *
     * @return
     */
    @Bean
    public IRule myRule() {
        // 轮询策略 --- RoundRobinRule()
        // 随机策略 --- RandomRule()
        // 自定义策略 --- MyLoadBalanced()
        return new RoundRobinRule();
    }
}
