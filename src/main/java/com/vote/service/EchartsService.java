package com.vote.service;

import com.vote.pojo.Echart;
import com.vote.pojo.EchartVO;

import java.util.List;

public interface EchartsService {

    public EchartVO getBarData();
    public EchartVO getPieData(String tid);
    public EchartVO getBarDataByPerson();
}
