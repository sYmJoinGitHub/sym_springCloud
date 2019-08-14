package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring cloud config分布式配置中心的客户端
 * <p>
 * Created by 沈燕明 on 2019/3/9.
 */
@SpringBootApplication
public class ConfigClientApp20000 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp20000.class, args);
    }
}
