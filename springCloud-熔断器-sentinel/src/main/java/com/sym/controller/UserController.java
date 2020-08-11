package com.sym.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sym.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.sym.constants.SentinelResourceConstants.DEFAULT_NAME;

/**
 * @author shenyanming
 * Created on 2020/7/11 17:36
 */
@RestController
@RequestMapping("/sentinel")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${serviceName}")
    private String serviceName;

    @GetMapping("/user/{user_id}")
    @SentinelResource(value = DEFAULT_NAME,
            blockHandler = "blockHandlerMethod", fallback = "fallbackMethod",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public UserBean getOne(@PathVariable("user_id") Integer userId){
        String url = "http://" + serviceName + "/provider/user/" + userId;
        return restTemplate.getForObject(url, UserBean.class);
    }

    /**
     * blockHandler 函数访问范围需要是 public，返回类型需要与原方法相匹配，
     * 参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException;
     *
     * blockHandler 函数默认需要和原方法在同一个类中. 若希望使用其他类的函数，则可以指定 blockHandlerClass 为对应的类的 Class 对象，
     * 注意对应的函数必需为 static 函数，否则无法解析
     */
    public UserBean blockHandlerMethod(Integer userId, BlockException blockException){
        return new UserBean();
    }

    /**
     * 用于在抛出异常的时候提供 fallback 处理逻辑, fallback 函数可以针对所有类型的异常（除了 exceptionsToIgnore 里面排除掉的异常类型）进行处理;
     * fallback函数要求返回值类型必须与原函数返回值类型一致, 方法参数列表需要和原函数一致，或者可以额外多一个 Throwable 类型的参数用于接收对应的异常.
     *
     * fallback 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 fallbackClass 为对应的类的 Class 对象，
     * 注意对应的函数必需为 static 函数，否则无法解析
     */
    public UserBean fallbackMethod(Integer userId, Throwable throwable){
        return new UserBean();
    }
}
