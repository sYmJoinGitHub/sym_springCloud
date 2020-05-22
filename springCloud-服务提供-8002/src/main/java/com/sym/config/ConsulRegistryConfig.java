package com.sym.config;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.cloud.consul.discovery.TtlScheduler;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistrationAutoConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistrationListener;
import org.springframework.cloud.consul.serviceregistry.ConsulManagementRegistrationCustomizer;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistrationCustomizer;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * spring cloud 通过这两个组件, 完成服务的注册：{@link Registration}、{@link ServiceRegistry}.
 * 在使用 Consul 作为注册中心, 这两个组件的实现类为：
 * {@link ConsulRegistration}、{@link ConsulServiceRegistry}
 * <p>
 * 因为我把注册中心集成到一个工程中(按道理一个工程一个注册中心), 所以需要单独做配置, 不然 spring cloud 会把所有
 * 注册中心的上面两个组件实现类都注册到IOC容器中, 这样在依赖引入的时候就会出错, 在这边单独作配置!
 * 通过自定义一个配置项 {sym.consul.enable} 如果这个配置项为true, 则 Consul 注册中心配置生效
 *
 * @author shenyanming
 * Created on 2020/5/21 18:16
 */
@Configuration
@ConditionalOnProperty(value = "sym.consul.enable", havingValue = "true")
public class ConsulRegistryConfig {


    /**
     * 注册到 Consul 的配置信息
     *
     * @see ConsulAutoServiceRegistrationAutoConfiguration#consulAutoServiceRegistration(
     *ConsulServiceRegistry, AutoServiceRegistrationProperties, ConsulDiscoveryProperties, ConsulAutoRegistration)
     */
    @Bean
    public ConsulAutoRegistration consulRegistration(
            AutoServiceRegistrationProperties autoServiceRegistrationProperties,
            ConsulDiscoveryProperties properties, ApplicationContext applicationContext,
            ObjectProvider<List<ConsulRegistrationCustomizer>> registrationCustomizers,
            ObjectProvider<List<ConsulManagementRegistrationCustomizer>> managementRegistrationCustomizers,
            HeartbeatProperties heartbeatProperties) {
        return ConsulAutoRegistration.registration(autoServiceRegistrationProperties,
                properties, applicationContext, registrationCustomizers.getIfAvailable(),
                managementRegistrationCustomizers.getIfAvailable(), heartbeatProperties);
    }

    /**
     * 注册到 Consul 的配置信息
     *
     * @see ConsulAutoServiceRegistrationAutoConfiguration#consulAutoServiceRegistration(
     *ConsulServiceRegistry, AutoServiceRegistrationProperties, ConsulDiscoveryProperties, ConsulAutoRegistration)
     */
    @Bean
    public ConsulAutoServiceRegistration consulAutoServiceRegistration(
            ConsulServiceRegistry registry,
            AutoServiceRegistrationProperties autoServiceRegistrationProperties,
            ConsulDiscoveryProperties properties,
            ConsulAutoRegistration consulRegistration) {
        return new ConsulAutoServiceRegistration(registry,
                autoServiceRegistrationProperties, properties, consulRegistration);
    }

    /**
     * consul 注册器
     */
    @Bean
    public ConsulServiceRegistry consulServiceRegistry(ConsulClient consulClient,
                                                       ConsulDiscoveryProperties properties, HeartbeatProperties heartbeatProperties,
                                                       @Autowired(required = false) TtlScheduler ttlScheduler) {
        return new ConsulServiceRegistry(consulClient, properties, ttlScheduler,
                heartbeatProperties);
    }

    /**
     * spring cloud 是通过注册 consul 事件监听器, 来启用自动注册的功能.
     * 当web容器初始化后, 会发布一个{@link WebServerInitializedEvent}事件,
     * 该监听器就能收到事件并将服务注册到 Consul 上
     *
     * @see ConsulAutoServiceRegistrationAutoConfiguration#consulAutoServiceRegistrationListener(ConsulAutoServiceRegistration)
     */
    @Bean
    public ConsulAutoServiceRegistrationListener consulAutoServiceRegistrationListener(
            ConsulAutoServiceRegistration registration) {
        return new ConsulAutoServiceRegistrationListener(registration);
    }
}
