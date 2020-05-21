package com.sym.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon组件的配置
 *
 * @author shenyanming
 * @date 2019/1/20
 */
@Configuration
public class RibbonConfig {

    /**
     * 注入RestTemplate并且开启负载均衡机制，
     * 必须加上{@link LoadBalanced}以便开启负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 替换springCloud默认的轮询策略的负载均衡机制为随机策略
     */
    @Bean
    public IRule myRule() {
        // 轮询策略 --- RoundRobinRule()
        // 随机策略 --- RandomRule()
        // 自定义策略 --- MyLoadBalanced()
        return new RoundRobinRule();
    }
}
