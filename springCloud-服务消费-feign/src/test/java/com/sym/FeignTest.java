package com.sym;

import com.sym.entity.response.LiveStudioTokenResponse;
import com.sym.service.LiveStudioFeignClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shenyanming
 * Created on 2020/6/5 15:37
 */
@SpringBootTest(classes = FeignApplication.class)
@RunWith(SpringRunner.class)
public class FeignTest {

    @Autowired
    private LiveStudioFeignClient feignClient;

    /**
     * 获取token
     */
    @Test
    public void test01() {
        String type = "client_credential";
        String appId = "";
        String secret = "";
        LiveStudioTokenResponse token = feignClient.getToken(type, appId, secret);
        System.out.println(token);
    }

}
