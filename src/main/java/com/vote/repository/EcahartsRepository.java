package com.vote.repository;

import com.vote.pojo.Echart;
import com.vote.pojo.EchartForPie;
import com.vote.pojo.EchartVO;

import java.util.List;

public interface EcahartsRepository {
    public List<Echart> getBarData();
    public EchartForPie getPieData(String tid,Integer ticketsType);
    public List<Echart> getBarDataByPerson();
}
