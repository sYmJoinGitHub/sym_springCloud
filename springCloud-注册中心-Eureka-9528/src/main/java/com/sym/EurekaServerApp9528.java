package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer集群节点，端口9528
 *
 * Created by 沈燕明 on 2019/1/21.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp9528 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp9528.class, args);
    }
}
