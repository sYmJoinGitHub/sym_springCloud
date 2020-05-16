package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by 沈燕明 on 2019/3/6.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer10086 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer10086.class, args);
    }
}
