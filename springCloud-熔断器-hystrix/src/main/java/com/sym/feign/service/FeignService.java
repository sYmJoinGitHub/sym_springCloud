package com.sym.feign.service;

import com.sym.entity.UserBean;
import com.sym.feign.config.FeignFallbackFactory;
import com.sym.feign.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * feign客户端
 *
 * @author shenyanming
 * @date 2019/10/12
 */
@FeignClient(name = "${serviceName}", path = "provider/user",
        configuration = FeignConfiguration.class,
        fallbackFactory = FeignFallbackFactory.class)
public interface FeignService {

    @RequestMapping("get/{id}")
    UserBean getUserById(@PathVariable("id") int userId);

    @RequestMapping("list")
    List<UserBean> getUserList();

    @RequestMapping("error")
    UserBean error();
}
