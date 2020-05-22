package com.sym;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过 Spring Cloud 原生注解 @RefreshScope 实现配置自动更新：
 *
 * @author shenyanming
 * Created on 2020/5/22 15:21
 */
@RestController
@RequestMapping("/demo")
@RefreshScope
public class DemoController {

    @Value("${nacos.demo.content:'default'}")
    private String  content;

    @RequestMapping("/get")
    public String get() {
        return content;
    }
}
