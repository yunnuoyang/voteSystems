package com.vote.controller;

import com.vote.pojo.ResultData;
import com.vote.pojo.Theme;
import com.vote.service.ThemeService;
import com.vote.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("theme")
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @RequestMapping("/updateTheme")
    public ModelAndView updateTheme(String id) {
        ModelAndView modelAndView=new ModelAndView();
        Theme theme=themeService.findThemeByID(id);
        modelAndView.addObject("curTheme",theme);
        modelAndView.setViewName("/updateTheme");
        return modelAndView;
    }

    @RequestMapping("add")
    public String addTheme(Theme theme) {
        theme.setId(UUID.getUUID());
//        theme.setThemeName("选举班长");
//        theme.setThemeDate(new Date(System.currentTimeMillis()));
//        theme.setEndDate(new Date(System.currentTimeMillis()));
        themeService.addTheme(theme);
        return "ok";
    }

    @RequestMapping("del")
    public String delTheme(@RequestParam("id") String id) {
        themeService.delTheme(id);
        return "ok";
    }

    @RequestMapping("modify")
    public String modifyTheme(Theme theme) {
        System.out.println(theme);
        return "ok";
    }

    @GetMapping("list")
    public ResultData themeList(Theme theme) {
        ResultData resultData = new ResultData();
        List<Theme> themes = themeService.themeList(theme);
        resultData.setCode(0);
        resultData.setCount(10);
        resultData.setMsg("ok");
        resultData.setData(themes);
        return resultData;
    }
}
