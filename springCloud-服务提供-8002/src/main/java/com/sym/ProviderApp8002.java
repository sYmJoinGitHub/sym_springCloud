package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 沈燕明 on 2019/1/27.
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderApp8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp8002.class,args);
    }
}
