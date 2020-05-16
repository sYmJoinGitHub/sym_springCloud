package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shenym on 2019/10/12.
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker  //开启hystrix
@EnableHystrixDashboard
public class HystrixConsumer81 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumer81.class, args);
    }

    /**
     * 注入RestTemplate并且开启负载均衡机制, 启动ribbon
     */
    @Bean
    @LoadBalanced //负载均衡注解
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
