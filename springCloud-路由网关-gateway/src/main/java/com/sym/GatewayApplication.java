package com.sym;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;


/**
 * Gateway相关概念：
 * - Route, 路由是构建网关的基本模块, 它由(ID + 目标URI + 断言和过滤器)断言和过滤器组成, 如果断言为true则匹配该路由;
 * - Predicate, 断言, 是指{@link Predicate}. 输入类型是{@link ServerWebExchange}, 可以匹配HTTP请求中的所有内容, 例如请求头或请求参数. 如果请求与断言相匹配，则进行路由；
 * - Filter, 过滤器, 是指{@link GatewayFilter}, 使用过滤器, 可以在请求被路由前后对请求进行修改.
 *
 * @author shenyanming
 * @date 2020/5/24 22:45.
 */
@Slf4j
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        log.info("服务启动成功~");
    }
}
