package com.sym;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author shenyanming
 * @date 2019/1/27
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@Slf4j
public class ProviderApp8002 {

    @Bean
    public AutoServiceRegistrationProperties autoServiceRegistrationProperties(){
        return new AutoServiceRegistrationProperties();
    }

    public static void main(String[] args) {
        log.info("provider-8002服务启动成功");
        SpringApplication.run(ProviderApp8002.class, args);
    }
}
