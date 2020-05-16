package com.sym.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sym.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shenym on 2019/10/12.
 */
@RestController
@RequestMapping("/hystrix/ribbon")
public class RibbonController {

    @Value("${serviceName}")
    private String serviceName;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用远程服务抛异常的方法
     */
    @RequestMapping("error")
    @HystrixCommand(fallbackMethod = "fallbackForError")
    public UserBean error() throws Exception {
        String url = "http://" + serviceName + "/provider/user/error";
        return restTemplate.getForObject(url, UserBean.class);
    }

    private UserBean fallbackForError() {
        return new UserBean(1, "default", "default", "出错了");
    }
}
