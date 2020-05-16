package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by 沈燕明 on 2019/3/3.
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication12580 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication12580.class, args);
    }
}
