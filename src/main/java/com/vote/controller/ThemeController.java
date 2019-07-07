package com.vote.controller;

import com.vote.pojo.Theme;
import com.vote.service.ThemeService;
import com.vote.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("theme")
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @PutMapping("add")
    public String addTheme(Theme theme) {
        theme.setId(UUID.getUUID());
//        theme.setThemeName("选举班长");
//        theme.setThemeDate(new Date(System.currentTimeMillis()));
//        theme.setEndDate(new Date(System.currentTimeMillis()));
        themeService.addTheme(theme);
        return "ok";
    }

    @DeleteMapping("del")
    public String delTheme(@RequestParam("id") String id) {
        themeService.delTheme(id);
        return "ok";
    }

    @PostMapping("modify")
    public String modifyTheme(Theme theme) {
        System.out.println(theme);
        return "ok";
    }

    @GetMapping("list")
    public List<Theme> themeList(Theme theme) {
        List<Theme> themes = themeService.themeList(theme);
        return themes;
    }

    public static void main(String[] args) {
        Theme theme = new Theme();
        theme.setThemeName("选举班长");
        int a = 0;
    }
}
