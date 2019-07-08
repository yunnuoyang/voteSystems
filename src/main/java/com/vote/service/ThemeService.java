package com.vote.service;


import com.vote.pojo.Theme;

import java.util.List;


public interface ThemeService {
   Integer addTheme(Theme theme);
   void delTheme(String id);
   List<Theme> themeList(Theme theme);
   Integer modifyTheme(Theme theme);

    Theme findThemeByID(String id);
}
