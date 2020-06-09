package com.sym.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * 微信小程序直播, 获取token时的响应实体
 *
 * @author shenyanming
 * Created on 2020/6/5 17:31
 */
@Data
@ToString
public class LiveStudioTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private int expiresIn;

    @JsonProperty(value = "errcode")
    private int errCode;

    @JsonProperty(value = "errmsg")
    private String errMsg;

    public boolean isSuccess() {
        return StringUtils.isNoneBlank(accessToken);
    }
}
