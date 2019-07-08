package com.vote.service.Impl;

import com.vote.pojo.Echart;
import com.vote.pojo.EchartForPie;
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

    @Override
    public EchartVO getPieData(String tid) {
        //获取投赞成票的票数
        EchartVO echartVO = new EchartVO();
        List<EchartForPie> list = new ArrayList<>();
        EchartForPie agree = ecahartsRepository.getPieData(tid, 1);
        agree.setName("赞成");
        list.add(agree);
        //获取投反对票的票数
        EchartForPie disagree = ecahartsRepository.getPieData(tid, 0);
        disagree.setName("反对");
        list.add(disagree);
        echartVO.setEcharts(list);

        return echartVO;
    }

}
