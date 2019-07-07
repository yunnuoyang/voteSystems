package com.vote.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Tickets {
    private String id;
    private  String uid;
    private String tid;
    // 投票时间
    private Date addData;
    // 投票类型   0 反对  1 赞成
    private int ticketsType;
}
