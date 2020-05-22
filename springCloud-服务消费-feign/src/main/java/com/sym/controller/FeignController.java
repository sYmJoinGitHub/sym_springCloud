package com.sym.controller;

import com.sym.entity.UserBean;
import com.sym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * springCloud的服务调用可以使用Feign来实现，只需要一个接口和一个@FeignClient注解即可
 *
 * @author shenyanming
 * @date 2019/1/20
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private IUserService userService;

    /**
     * 调用远程服务，获取当个用户的信息
     */
    @RequestMapping("/get/{id}")
    public UserBean getOne(@PathVariable("id") int userId) {
        return userService.getUserById(userId);
    }

    /**
     * 调用远程服务，获取全部的用户信息
     */
    @RequestMapping("/list")
    public List<UserBean> getList() {
        return userService.getUserList();
    }

}
