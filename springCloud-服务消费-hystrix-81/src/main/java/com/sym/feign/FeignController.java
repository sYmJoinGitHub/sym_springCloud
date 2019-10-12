package com.sym.feign;

import com.sym.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shenym on 2019/10/12.
 */
@RestController
@RequestMapping("/hystrix/feign")
public class FeignController {

    @Autowired
    private FeignService feignService;

    /**
     * 调用远程服务，获取当个用户的信息
     */
    @RequestMapping("/get/{id}")
    public UserBean getOne(@PathVariable("id") int userId) throws Exception {
        return feignService.getUserById(userId);
    }


    /**
     * 调用远程服务，获取全部的用户信息
     */
    @RequestMapping("/list")
    public List<UserBean> getList() throws Exception {
        return feignService.getUserList();
    }

    /**
     * hystrix熔断器
     */
    @RequestMapping("/error")
    public UserBean error() {
        return feignService.error();
    }
}
