package com.vote.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Theme {
    private String id;
    private String themeName;
    // 发布主题事件
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date themeDate;
    // 投票截止时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public Date getThemeDate() {
        return themeDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getThemeDate(Date date) {
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        String format = smf.format(date);
        return format;
    }

    public void setThemeDate(Date themeDate) {
        this.themeDate = themeDate;
    }
}
