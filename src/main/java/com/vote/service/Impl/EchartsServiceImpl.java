package com.vote.service.Impl;

import com.vote.pojo.Echart;
import com.vote.pojo.EchartVO;
import com.vote.repository.EcahartsRepository;
import com.vote.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EchartsServiceImpl  implements EchartsService {

    @Autowired
    private EcahartsRepository ecahartsRepository;

    @Override
    public EchartVO getBarData() {
        List<Echart> barData = ecahartsRepository.getBarData();
        EchartVO echartVO = new EchartVO();
        List<String> date = new ArrayList<String>();
        List<Integer> count = new ArrayList<Integer>();
        for(Echart echart : barData){
            date.add(echart.getDate());
            count.add(echart.getCount());
        }
        echartVO.setDate(date);
        echartVO.setCount(count);
        return echartVO;
    }
}
