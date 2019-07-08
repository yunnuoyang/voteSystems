package com.vote.pojo;

import lombok.Data;

import java.util.List;

@Data
public class EchartVO {
    private List<String> date;
    private List<Integer> count;
    private List<EchartForPie> echarts;
 }
