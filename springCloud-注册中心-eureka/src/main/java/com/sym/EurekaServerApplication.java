package com.sym;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心 Eureka Server 的启动类
 *
 * @author shenyanming
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
        log.info("Eureka Server started");
    }
}
