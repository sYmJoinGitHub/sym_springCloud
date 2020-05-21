package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 基于 Feign 的springCloud服务消费端
 *
 * @author shenyanming
 * @date 2019/1/20
 */
@SpringBootApplication(exclude = {EurekaClientAutoConfiguration.class, EurekaDiscoveryClientConfiguration.class})
@EnableFeignClients
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
