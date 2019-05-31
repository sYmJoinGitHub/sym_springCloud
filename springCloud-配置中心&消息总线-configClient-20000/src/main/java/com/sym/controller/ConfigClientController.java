package com.sym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 沈燕明 on 2019/3/9.
 */
@RestController
//@RefreshScope 借助springBoot-actuator手动刷新配置
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private int port;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Autowired
    private Environment env;

    /**
     * 访问此url，看看这个工程读取的是哪个配置
     * @return
     * @throws Exception
     */
    @GetMapping("config")
    public Map rest() throws Exception{
        System.out.println("启动的配置为："+applicationName+"\t"+port+"\t"+instanceId);
        Map<String,Object> map = new HashMap<>();
        map.put("applicationName",applicationName);
        map.put("port",port);
        map.put("instanceId",instanceId);
        return map;
    }

    /**
     * Environment可以获取springBoot当前的一些配置
     * @param key
     * @return
     * @throws Exception
     */
    @GetMapping("getProp")
    public String getProp(String key) throws Exception{
        String property = env.getProperty(key);
        return property == null?"获取不到":property;
    }
}
