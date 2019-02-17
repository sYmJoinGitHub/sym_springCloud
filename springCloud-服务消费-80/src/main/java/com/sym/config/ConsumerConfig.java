package com.sym.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 沈燕明 on 2019/1/20.
 */
@Configuration
public class ConsumerConfig {

    @Bean
    @LoadBalanced //负载均衡注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        // 更换为随机策略
        return new RetryRule();
    }
}
