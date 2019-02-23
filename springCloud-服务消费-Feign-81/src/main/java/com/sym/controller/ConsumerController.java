package com.sym.controller;

import com.sym.entity.UserBean;
import com.sym.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * springCloud的服务调用可以使用Feign来实现，只需要一个接口和一个@FeignClient注解即可
 *
 * Created by 沈燕明 on 2019/1/20.
 */
@RestController()
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private UserServiceI userServiceI;

    /**
     * 调用远程服务，获取当个用户的信息
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("get/{id}")
    public UserBean getOne(@PathVariable("id")int userId) throws Exception{
        return userServiceI.getUserById(userId);
    }

    /**
     * 调用远程服务，获取全部的用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public List<UserBean> getList() throws Exception{
        return userServiceI.getUserList();
    }





}
