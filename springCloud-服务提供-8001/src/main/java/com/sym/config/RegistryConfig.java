package com.sym.config;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulManagementRegistrationCustomizer;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistrationCustomizer;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistry;
import org.springframework.cloud.netflix.eureka.CloudEurekaInstanceConfig;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * springCloud 注册中心的配置
 *
 * @author shenyanming
 * Created on 2020/5/21 18:16
 */
@Configuration
public class RegistryConfig {

    @Bean
    @ConditionalOnProperty(value = "sym.eureka.enable", havingValue = "true")
    public EurekaRegistration eurekaRegistration(EurekaClient eurekaClient,
                                                 CloudEurekaInstanceConfig instanceConfig,
                                                 ApplicationInfoManager applicationInfoManager,
                                                 @Autowired(required = false) ObjectProvider<HealthCheckHandler> healthCheckHandler) {
        return EurekaRegistration.builder(instanceConfig).with(applicationInfoManager)
                .with(eurekaClient).with(healthCheckHandler).build();
    }

    @Bean
    @ConditionalOnProperty(value = "sym.consul.enable", havingValue = "true")
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

    @Bean
    public AutoServiceRegistrationProperties autoServiceRegistrationProperties(){
        return new AutoServiceRegistrationProperties();
    }

    @Bean
    @ConditionalOnProperty(value = "sym.consul.enable", havingValue = "true")
    public ConsulAutoRegistry consulAutoRegistration(ConsulServiceRegistry consulServiceRegistry,
                                                     ConsulAutoRegistration consulAutoRegistration){
        return new ConsulAutoRegistry(consulServiceRegistry, consulAutoRegistration);
    }

    static class ConsulAutoRegistry{
        public ConsulAutoRegistry(ConsulServiceRegistry consulServiceRegistry,
                                  ConsulAutoRegistration consulAutoRegistration){
            consulServiceRegistry.register(consulAutoRegistration);
        }
    }
}
