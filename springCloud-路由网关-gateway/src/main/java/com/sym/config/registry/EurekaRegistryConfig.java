package com.sym.config.registry;

import com.alibaba.cloud.nacos.ribbon.NacosRibbonClientConfiguration;
import com.alibaba.cloud.nacos.ribbon.NacosServerIntrospector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.ribbon.ServerIntrospector;
import org.springframework.cloud.netflix.ribbon.eureka.EurekaServerIntrospector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 服务消费方不需要注册, 所以不用处理 spring cloud 的服务注册组件, 只需要创建相应的
 * {@link ServerIntrospector}即可
 *
 * @author shenyanming
 * Created on 2020/5/22 10:20
 */
@Configuration
@ConditionalOnProperty(value = "sym.eureka.enable", havingValue = "true")
public class EurekaRegistryConfig {

    @Bean
    @Primary
    public EurekaServerIntrospector eurekaServerIntrospector(){
        return new EurekaServerIntrospector();
    }

    /**
     * 为了防止{@link NacosRibbonClientConfiguration#nacosServerIntrospector()}注册组件,
     * 但是有个问题, 上面那个方法都已经加了{@link Primary}了, 为啥如果注释掉下面的方法就没办法生效.
     */
    @Bean
    public NacosServerIntrospector nacosServerIntrospector(){
        return new NacosServerIntrospector();
    }
}
