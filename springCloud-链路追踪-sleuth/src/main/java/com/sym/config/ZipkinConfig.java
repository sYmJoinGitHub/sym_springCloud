package com.sym.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * zipkin server下载地址:
 * https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec
 * 可以将其以java -jar的命令启动, 用于快速启动程序.
 * springCloud 与 zipkin 的关系: Zipkin收集 Sleuth 产生的数据，并以界面的形式呈现出来
 *
 * @author shenyanming
 * Created on 2020/8/11 13:35
 */
@Configuration
public class ZipkinConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
