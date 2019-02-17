package com.sym;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * springCloud的服务消费方
 * <p>
 * Created by 沈燕明 on 2019/1/20.
 */
@SpringBootApplication
public class ConsumerApp80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp80.class, args);
    }
}
