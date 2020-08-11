package com.sym.controller;

import com.sym.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author shenyanming
 * Created on 2020/8/11 13:49
 */
@RestController
@RequestMapping("/sleuth")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.name}")
    private String serviceName;

    @GetMapping("/user/{id}")
    public UserBean getOne(@PathVariable("id") Integer userId) {
        return restTemplate.getForObject("http://" + serviceName + "/provider/user/get/" + userId, UserBean.class);
    }
}
