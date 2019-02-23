package com.sym;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * springCloud的服务消费方
 * <p>
 * Created by 沈燕明 on 2019/1/20.
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerApp81 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp81.class, args);
    }
}
