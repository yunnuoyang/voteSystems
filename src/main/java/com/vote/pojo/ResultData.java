package com.vote.pojo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class ResultData {
    private Integer code;
    private String msg;
    private Integer count;
    private List<?> data;

}
