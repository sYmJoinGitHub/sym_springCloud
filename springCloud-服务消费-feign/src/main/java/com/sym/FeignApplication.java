package com.sym;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * 基于 Feign 的springCloud服务消费端
 *
 * @author shenyanming
 * @date 2019/1/20
 */
@SpringBootApplication(exclude = {EurekaClientAutoConfiguration.class, EurekaDiscoveryClientConfiguration.class})
@EnableFeignClients
@Slf4j
public class FeignApplication {

    @Bean
    public AutoServiceRegistrationProperties autoServiceRegistrationProperties(){
        return new AutoServiceRegistrationProperties();
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
        log.info("feign consumer 启动完成");
    }
}
