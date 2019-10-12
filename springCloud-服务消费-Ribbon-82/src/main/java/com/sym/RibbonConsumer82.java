package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于Ribbon的springCloud服务消费端
 *
 * Created by 沈燕明 on 2019/1/20.
 */
@SpringBootApplication
public class RibbonConsumer82 {
    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumer82.class, args);
    }
}
