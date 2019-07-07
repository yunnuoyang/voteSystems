package com.vote.service.Impl;

import com.vote.pojo.Theme;
import com.vote.repository.ThemeRepository;
import com.vote.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public Integer addTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    @Override
    public void delTheme(String id) {
        themeRepository.deleteById(id);
    }

    @Override
    public List<Theme> themeList(Theme theme) {
        return themeRepository.findAll(theme);
    }

    @Override
    public Integer modifyTheme(Theme theme) {
        return null;
    }
}
