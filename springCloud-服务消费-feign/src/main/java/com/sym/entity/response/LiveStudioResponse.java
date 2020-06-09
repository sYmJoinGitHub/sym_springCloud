package com.sym.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * 微信小程序直播, 获取直播间信息响应实体
 *
 * @author shenyanming
 * Created on 2020/6/5 17:33
 */
@Data
public class LiveStudioResponse {
    @JsonProperty("errcode")
    private Integer errCode;

    @JsonProperty("errmsg")
    private String errMsg;

    @JsonProperty("total")
    private Long total;

    /**
     * 直播间信息
     */
    @JsonProperty("room_info")
    private List<LiveStudioRoomResponse> roomInfo;

    public boolean isSuccess(){
        return Objects.nonNull(errCode) && errCode == 0;
    }
}
