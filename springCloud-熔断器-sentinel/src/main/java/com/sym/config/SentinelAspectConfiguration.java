package com.sym.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 1.若是通过 Spring Cloud Alibaba 接入的 Sentinel，则无需额外进行配置即可使用 @SentinelResource 注解；
 * 2.若是普通spring或springBoot应用, 通过配置的方式将 SentinelResourceAspect 注册为一个 Spring Bean;
 * 3.
 *
 * @author shenyanming
 * Created on 2020/7/11 17:42
 */
@Configuration
public class SentinelAspectConfiguration {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}