package com.sym.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 直播间信息响应实体
 *
 * @author shenyanming
 * Created on 2020/6/5 17:34
 */
@Data
public class LiveStudioRoomResponse {
    private String name;

    @JsonProperty("roomid")
    private Integer roomId;

    @JsonProperty("cover_img")
    private String backgroundWallUrl;

    @JsonProperty("share_img")
    private String shareCardUrl;

    @JsonProperty("live_status")
    private Integer status;

    @JsonProperty("start_time")
    private Long timeStart;

    @JsonProperty("end_time")
    private Long timeEnd;

    @JsonProperty("anchor_name")
    private String nickname;

    /**
     * 该直播间的商品
     */
    List<LiveStudioGoodsResponse> goods;
}
