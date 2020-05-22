package com.sym.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.consul.discovery.ConsulServerIntrospector;
import org.springframework.cloud.netflix.ribbon.ServerIntrospector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 服务消费方不需要注册, 所以不用处理 spring cloud 的服务注册组件, 只需要创建相应的
 * {@link ServerIntrospector}即可
 *
 * @author shenyanming
 * Created on 2020/5/21 18:16
 */
@Configuration
@ConditionalOnProperty(value = "sym.consul.enable", havingValue = "true")
public class ConsulRegistryConfig {

    @Bean
    @Primary
    public ConsulServerIntrospector consulServerIntrospector() {
        return new ConsulServerIntrospector();
    }

}
