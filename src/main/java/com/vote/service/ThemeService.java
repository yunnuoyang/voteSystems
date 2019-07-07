package com.vote.service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.vote.pojo.Theme;

import java.util.List;


public interface ThemeService {
   Integer addTheme(Theme theme);
   void delTheme(String id);
   List<Theme> themeList(Theme theme);
   Integer modifyTheme(Theme theme);
}
