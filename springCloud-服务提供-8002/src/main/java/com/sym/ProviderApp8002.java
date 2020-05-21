package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author shenyanming
 * @date 2019/1/27
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderApp8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp8002.class, args);
    }
}
