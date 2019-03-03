package com.sym.controller;

import com.sym.entity.UserBean;
import com.sym.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 因为springCloud是基于REST调用服务的，所以服务提供时，要写在Controller层
 * <p>
 * Created by 沈燕明 on 2019/1/20.
 */
@RestController
@RequestMapping("provider/user")
public class UserController {

    @Autowired
    private UserServiceI userService;

    /**
     * 用于服务发现功能，了解下有这个组件即可
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取单个用户信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("get/{id}")
    public UserBean getUserById(@PathVariable("id") int userId) throws Exception {
        return userService.getUserById(userId);
    }

    /**
     * 获取所有用户的信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public List<UserBean> getUserList() throws Exception {
        return userService.getUserList();
    }

    /**
     * 服务提供方抛出异常，供消费者测试服务熔断
     * @return
     * @throws Exception
     */
    @RequestMapping("error")
    public UserBean error() throws Exception{
        throw new RuntimeException("服务提供-8002-抛出异常");
    }

    /**
     * 服务发现功能，了解下有这个功能即可
     * 提供提供方的服务功能信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("discovery")
    public DiscoveryClient DiscoveryClient() throws Exception {
        // 获取所有的服务信息
        List<String> services = discoveryClient.getServices();
        System.out.println("所有服务信息：" + services);
        // 获取本服务信息，参数本服务的应用名称
        List<ServiceInstance> instances = discoveryClient.getInstances("springCloud-provider");
        instances.stream().forEach((a) -> {
            System.out.println(a.getHost() + "\t" + a.getPort() + "\t" + a.getUri() + a.getServiceId() + "\t" + a.getMetadata());
        });
        return discoveryClient;
    }


}
