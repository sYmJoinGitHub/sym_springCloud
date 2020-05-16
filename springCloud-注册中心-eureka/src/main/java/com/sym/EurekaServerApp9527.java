package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * springCloud注册中心的启动类
 * <p>
 * Created by 沈燕明 on 2019/1/15.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp9527 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp9527.class, args);
    }
}
