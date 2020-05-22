package com.sym.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import com.alibaba.cloud.nacos.registry.NacosRegistration;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistry;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistryAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring cloud 通过这两个组件, 完成服务的注册：{@link Registration}、{@link ServiceRegistry}.
 * 在使用 Nacos 作为注册中心, 这两个组件的实现类为：
 * {@link NacosRegistration}、{@link NacosServiceRegistry}
 * <p>
 * 因为我把注册中心集成到一个工程中(按道理一个工程一个注册中心), 所以需要单独做配置, 不然 spring cloud 会把所有
 * 注册中心的上面两个组件实现类都注册到IOC容器中, 这样在依赖引入的时候就会出错, 在这边单独作配置!
 * 通过自定义一个配置项 {sym.nacos.enable} 如果这个配置项为true, 则 Nacos 注册中心配置生效
 *
 * @author shenyanming
 * Created on 2020/5/22 16:13
 */
@Configuration
@ConditionalOnProperty(value = "sym.nacos.enable", havingValue = "true")
public class NacosRegistryConfig {

    /**
     * nacos 注册信息
     * @see NacosServiceRegistryAutoConfiguration
     */
    @Bean
    public NacosRegistration nacosRegistration(
            NacosDiscoveryProperties nacosDiscoveryProperties,
            ApplicationContext context) {
        return new NacosRegistration(nacosDiscoveryProperties, context);
    }

    /**
     * nacos 自动注册信息, 它是{@link AbstractAutoServiceRegistration}的子类,
     * 也是一个{@link ApplicationListener}, 通过事件回调完成服务注册
     *
     * @see NacosServiceRegistryAutoConfiguration
     */
    @Bean
    public NacosAutoServiceRegistration nacosAutoServiceRegistration(
            NacosServiceRegistry registry,
            AutoServiceRegistrationProperties autoServiceRegistrationProperties,
            NacosRegistration registration) {
        return new NacosAutoServiceRegistration(registry,
                autoServiceRegistrationProperties, registration);
    }

    /**
     * nacos 注册器
     * @see NacosServiceRegistryAutoConfiguration
     */
    @Bean
    public NacosServiceRegistry nacosServiceRegistry(
            NacosDiscoveryProperties nacosDiscoveryProperties) {
        return new NacosServiceRegistry(nacosDiscoveryProperties);
    }
}
