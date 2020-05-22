package com.sym.controller;

import com.sym.entity.UserBean;
import com.sym.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.Line;
import java.util.List;

/**
 * 因为springCloud是基于REST调用服务的，所以服务提供时，要写在Controller层
 *
 * @author shenyanming
 * @date 2019/1/20
 */
@RestController
@RequestMapping("/provider/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用于服务发现功能，了解下有这个组件即可
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration;

    /**
     * 获取单个用户信息
     */
    @GetMapping("/get/{id}")
    public UserBean getUserById(@PathVariable("id") int userId) {
        log.info("[8001]获取单个用户信息：{}", userId);
        return userService.getUserById(userId);
    }

    /**
     * 获取所有用户的信息
     */
    @RequestMapping("/list")
    public List<UserBean> getUserList() {
        log.info("[8001]获取所有用户信息");
        return userService.getUserList();
    }

    /**
     * 服务提供方抛出异常，供消费者测试服务熔断
     */
    @RequestMapping("/error")
    public UserBean error()  {
        log.error("[8001]模拟异常");
        throw new RuntimeException("服务提供-8001-抛出异常");
    }

    /**
     * 服务发现功能，了解下有这个功能即可：提供提供方的服务功能信息
     */
    @RequestMapping("/discovery")
    public DiscoveryClient discoveryClient() {
        log.info("[8001]服务发现, 注册信息：{}", registration);
        // 获取所有的服务信息
        List<String> services = discoveryClient.getServices();
        System.out.println("所有服务信息：" + services);
        // 获取本服务信息，参数本服务的应用名称
        List<ServiceInstance> instances = discoveryClient.getInstances("springCloud-provider");
        instances.forEach((a) -> {
            System.out.println(a.getHost() + "\t" + a.getPort() + "\t" + a.getUri() + a.getServiceId() + "\t" + a.getMetadata());
        });
        return discoveryClient;
    }


}
