package com.sym.service;

import com.sym.entity.response.LiveStudioResponse;
import com.sym.entity.response.LiveStudioTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign可以当做一个HTTP客户端.
 * 对接微信小程序直播的API
 *
 * @author shenyanming
 * Created on 2020/6/5 15:47
 */
@FeignClient(url = "${wx.api:https://api.weixin.qq.com}", name = "wx-live-studio")
public interface LiveStudioFeignClient {

    /**
     * 获取小程序的token
     *
     * @param type   类型
     * @param appId  小程序唯一凭证
     * @param secret 小程序唯一凭证密钥
     * @return 微信响应实体
     */
    @GetMapping("/cgi-bin/token")
    LiveStudioTokenResponse getToken(@RequestParam("grant_type") String type,
                                     @RequestParam("appid") String appId,
                                     @RequestParam("secret") String secret);


    /**
     * 获取直播房间列表
     *
     * @param token    凭据
     * @param bodyJson body域
     * @return 微信响应实体
     */
    @PostMapping("/wxa/business/getliveinfo")
    LiveStudioResponse getLiveInfo(@RequestParam("access_token") String token,
                                   @RequestBody String bodyJson);
}
