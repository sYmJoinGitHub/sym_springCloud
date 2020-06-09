package com.sym.entity;

import lombok.Data;

/**
 * 小程序直播间
 *
 * @author shenyanming
 * Created on 2020/6/5 11:18
 */
@Data
public class LiveStudioRoom {


    private String id;

    private Integer roomId;

    private String name;

    private Long timeStart;

    private Long timeEnd;

    private Integer status;

    private String nickname;

    private Integer goodCount;

    private String backgroundWallUrl;

    private String shareCardUrl;

    private Long timeCreate;

    private Long timeUpdate;
}
