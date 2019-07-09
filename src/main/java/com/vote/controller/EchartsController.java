package com.vote.controller;

import com.vote.pojo.Echart;
import com.vote.pojo.EchartVO;
import com.vote.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    private EchartsService echartsService;

    @GetMapping("/getBarData")
    @ResponseBody
    public EchartVO getBarData(){
        System.out.println("进入controller");
        EchartVO data = echartsService.getBarData();
        return  data;
    }

    @GetMapping("/getPieData/{tid}")
    @ResponseBody
    public EchartVO getPieData(@PathVariable String tid){
        System.out.println("进入controller"+tid);
        EchartVO echartVO = echartsService.getPieData(tid);
        return echartVO;
    }

    @GetMapping("/getBarData2")
    @ResponseBody
    public EchartVO getBarData2(){
        System.out.println("进入controller");
        EchartVO data = echartsService.getBarDataByPerson();
        return  data;
    }
}
