package com.sym.controller;

import com.sym.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * springCloud的服务调用是基于HTTP的REST调用，所以服务消费方使用
 * RestTemplate来调用远程服务
 *
 * Created by 沈燕明 on 2019/1/20.
 */
@RestController()
@RequestMapping("consumer")
public class ConsumerController {

    @Value("${serviceName}")
    private String serviceName;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用远程服务，获取当个用户的信息
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("get/{id}")
    public UserBean getOne(@PathVariable("id")int userId) throws Exception{
        String url = "http://"+serviceName+"/provider/user/get/"+userId;
        return restTemplate.getForObject(url,UserBean.class);
    }

    /**
     * 调用远程服务，获取全部的用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    @SuppressWarnings("unchecked")
    public List<UserBean> getList() throws Exception{
        String url = "http://"+serviceName+"/provider/user/list";
        return restTemplate.getForObject(url,List.class);
    }





}
