package com.sym.config;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.cloud.netflix.eureka.CloudEurekaInstanceConfig;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaAutoServiceRegistration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaServiceRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring cloud 通过这两个组件, 完成服务的注册：{@link Registration}、{@link ServiceRegistry}.
 * 在使用Eureka作为注册中心, 这两个组件的实现类为：
 * {@link EurekaRegistration}、{@link EurekaServiceRegistry}
 *
 * 因为我把注册中心集成到一个工程中(按道理一个工程一个注册中心), 所以需要单独做配置, 不然 spring cloud 会把所有
 * 注册中心的上面两个组件实现类都注册到IOC容器中, 这样在依赖引入的时候就会出错, 在这边单独作配置!
 * 通过自定义一个配置项 {sym.eureka.enable} 如果这个配置项为true, 则 Eureka 注册中心配置生效
 *
 * @author shenyanming
 * Created on 2020/5/22 10:20
 */
@Configuration
@ConditionalOnProperty(value = "sym.eureka.enable", havingValue = "true")
public class EurekaRegistryConfig {

    /**
     * 注册到 Eureka 的配置信息
     * @see EurekaClientAutoConfiguration.EurekaClientConfiguration#eurekaRegistration(
     * EurekaClient, CloudEurekaInstanceConfig, ApplicationInfoManager, ObjectProvider)
     */
    @Bean
    public EurekaRegistration eurekaRegistration(EurekaClient eurekaClient,
                                                 CloudEurekaInstanceConfig instanceConfig,
                                                 ApplicationInfoManager applicationInfoManager,
                                                 @Autowired(required = false) ObjectProvider<HealthCheckHandler> healthCheckHandler) {
        return EurekaRegistration.builder(instanceConfig).with(applicationInfoManager)
                .with(eurekaClient).with(healthCheckHandler).build();
    }

    /**
     * spring cloud 对 eureka 的注册不同于 consul, 后者是通过监听回调机制自动注册的. 而对于 eureka
     * 使用{@link EurekaAutoServiceRegistration}, 它实现了{@link Lifecycle}接口, 会在容器启动时
     * 回调{@link Lifecycle#start()}方法, 在这里面实现 Eureka 的注册
     *
     * @see EurekaClientAutoConfiguration#eurekaAutoServiceRegistration(
     * ApplicationContext, EurekaServiceRegistry, EurekaRegistration)
     */
    @Bean
    public EurekaAutoServiceRegistration eurekaAutoServiceRegistration(
            ApplicationContext context, EurekaServiceRegistry registry,
            EurekaRegistration registration) {
        return new EurekaAutoServiceRegistration(context, registry, registration);
    }
}
