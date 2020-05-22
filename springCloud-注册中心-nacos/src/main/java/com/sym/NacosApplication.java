package com.sym;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * nacos和consul一样, 它们的服务端都需要独立部署, 需要从github官网上：https://github.com/alibaba/nacos 下载安装包,
 * 解压后, 执行命令：sh startup.sh -m standalone（standalone代表着单机模式运行，非集群模式）
 *
 *
 * @author shenyanming
 * Created on 2020/5/22 15:06
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
        log.info("nacos服务注册成功.");
    }
}
