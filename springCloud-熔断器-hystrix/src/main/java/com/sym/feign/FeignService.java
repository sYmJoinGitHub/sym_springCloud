package com.sym.feign;

import com.sym.entity.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by shenym on 2019/10/12.
 */
@FeignClient(name = "${serviceName}",
        path = "provider/user",
        fallbackFactory = FeignFallbackFactory.class)
public interface FeignService {

    @RequestMapping("get/{id}")
    UserBean getUserById(@PathVariable("id") int UserId);

    @RequestMapping("list")
    List<UserBean> getUserList();

    @RequestMapping("error")
    UserBean error();
}
