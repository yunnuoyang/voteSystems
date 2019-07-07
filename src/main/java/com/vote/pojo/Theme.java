package com.vote.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class Theme {
    private  String id;
    private  String themeName;
    // 发布主题事件
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date themeDate;
    // 投票截止时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date endDate;

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

    public void setThemeDate(Date themeDate) {
        this.themeDate = themeDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
