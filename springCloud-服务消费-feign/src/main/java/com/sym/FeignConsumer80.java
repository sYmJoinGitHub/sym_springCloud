package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 基于 Feign 的springCloud服务消费端
 *
 * Created by 沈燕明 on 2019/1/20.
 */
@SpringBootApplication
@EnableFeignClients
public class FeignConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumer80.class, args);
    }
}
