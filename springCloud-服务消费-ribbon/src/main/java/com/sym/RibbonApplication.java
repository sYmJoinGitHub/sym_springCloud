package com.sym;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.consul.discovery.ConsulRibbonClientConfiguration;
import org.springframework.cloud.netflix.ribbon.eureka.EurekaRibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 基于Ribbon的springCloud服务消费端
 *
 * @author shenyanming
 * @date 2019/1/20
 */
@SpringBootApplication
@Slf4j
public class RibbonApplication {

    @Bean
    public AutoServiceRegistrationProperties autoServiceRegistrationProperties(){
        return new AutoServiceRegistrationProperties();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
        log.info("ribbon consumer 启动完成");
    }
}
