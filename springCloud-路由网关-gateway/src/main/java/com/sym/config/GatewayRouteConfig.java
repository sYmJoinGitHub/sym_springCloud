package com.sym.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;

/**
 * 路由网关配置类, 可以用.yml文件配置, 也可以直接配置在代码里
 *
 * @author shenyanming
 * Created on 2020/8/8 15:55
 */
@Configuration
public class GatewayRouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/about")
                        .uri("http://ityouknow.com"))
                .build();
    }

    @Bean
    public ServerCodecConfigurer serverCodecConfigurer(){
        return new DefaultServerCodecConfigurer();
    }

}
