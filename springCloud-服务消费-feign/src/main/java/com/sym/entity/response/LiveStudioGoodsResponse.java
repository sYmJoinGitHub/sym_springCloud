package com.sym.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 直播间商品信息响应实体
 *
 * @author shenyanming
 * Created on 2020/6/5 17:33
 */
@Data
public class LiveStudioGoodsResponse {
    @JsonProperty("cover_img")
    private String coverImg;

    private String url;
    private Integer price;
    private String name;
}
