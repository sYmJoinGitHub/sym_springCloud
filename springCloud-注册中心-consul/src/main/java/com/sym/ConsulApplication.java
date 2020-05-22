package com.sym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Consul 是 HashiCorp 公司推出的使用GO语言开发的开源工具, 用于实现分布式系统的服务发现与配置.
 * Consul 的方案更“一站式”，内置了服务注册与发现框架、分布一致性协议实现、健康检查、Key/Value 存储、多数据中心方案，
 * 不再需要依赖其它工具（比如 ZooKeeper 等）。
 *
 * Consul 与 Eureka不同, 它的服务端需要单独部署, 所以需要先安装, 官网下载地址为：
 * https://www.consul.io/downloads.html
 *
 * @author shenyanming
 * Created on 2020/5/16 18:01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulApplication.class, args);
    }
}
