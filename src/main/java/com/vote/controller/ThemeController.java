package com.vote.controller;

import com.vote.pojo.ResultData;
import com.vote.pojo.Theme;
import com.vote.service.ThemeService;
import com.vote.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/theme")
public class ThemeController {
    @Autowired
    private ThemeService themeService;
    @RequestMapping("{PATH}")
    public String path(@PathVariable String PATH){
        return PATH;
    }

    @RequestMapping("/updateTheme")
    public ModelAndView updateTheme(String id) {
        ModelAndView modelAndView=new ModelAndView();
        Theme theme=themeService.findThemeByID(id);
        modelAndView.addObject("curTheme",theme);
        modelAndView.setViewName("/updateTheme");
        return modelAndView;
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String addTheme(Theme theme) {
        theme.setId(UUID.getUUID());
//        theme.setThemeName("选举班长");
//        theme.setThemeDate(new Date(System.currentTimeMillis()));
//        theme.setEndDate(new Date(System.currentTimeMillis()));
        themeService.addTheme(theme);
        return "ok";
    }

    @RequestMapping("del")
    @ResponseBody
    public String delTheme(@RequestParam("id") String id) {
        themeService.delTheme(id);
        return "ok";
    }

    @RequestMapping(value = "modify",method = RequestMethod.POST)
    @ResponseBody
    public String modifyTheme(Theme theme) {
        System.out.println(theme);
        themeService.modifyTheme(theme);
        return "ok";
    }

    @GetMapping("list")
    @ResponseBody
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
