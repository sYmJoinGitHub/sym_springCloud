package com.sym.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sym.entity.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.sym.properties.HystrixCommandPropertiesConstants.ThreadIsolation.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS;
import static com.sym.properties.HystrixCommandPropertiesConstants.ThreadIsolation.EXECUTION_ISOLATION_STRATEGY;
import static com.sym.properties.HystrixCommandPropertiesConstants.ThreadIsolation.EXECUTION_TIMEOUT_ENABLED;

/**
 * 通过{@link HystrixCommand}实现降级和熔断
 *
 * @author shenyanming
 * @date 2019/10/12
 */
@RestController
@RequestMapping("/hystrix/ribbon")
@Slf4j
public class RibbonController {

    @Value("${serviceName}")
    private String serviceName;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用远程服务抛异常的方法
     */
    @RequestMapping("/error")
    @HystrixCommand(fallbackMethod = "fallbackForError")
    public UserBean error() {
        String url = "http://" + serviceName + "/provider/user/error";
        return restTemplate.getForObject(url, UserBean.class);
    }

    private UserBean fallbackForError() {
        return new UserBean(1, "default", "default", "出错了");
    }

    /**
     * 接口限流
     */
    @GetMapping("/{value}")
    @HystrixCommand(fallbackMethod = "getUserV1Fallback",
            commandProperties = {
                    @HystrixProperty(name = EXECUTION_ISOLATION_STRATEGY, value = "SEMAPHORE"),
                    @HystrixProperty(name = EXECUTION_TIMEOUT_ENABLED, value = "false"),
                    @HystrixProperty(name = EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "1")
            }
    )
    public UserBean getUserV1(@PathVariable("value") int value) throws InterruptedException {
        // 让线程睡眠, 模拟复杂请求调用
        log.info("处理线程: {}", Thread.currentThread().getName());

        Thread.sleep(value * 1000);
        return new UserBean().setUserId(11).setUserName("goods").setPassword("123").setDatabase("database-01");
    }

    public UserBean getUserV1Fallback(int value) {
        return UserBean.FALLBACK_INSTANCE;
    }
}
