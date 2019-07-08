package com.vote.repository;

import com.vote.pojo.Theme;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface ThemeRepository {
    @Select("select * from theme ")
    @Results(id = "resultMap", value = {
            @Result(column = "id", property = "id", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "themeName", property = "themeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "themeDate", property = "themeDate", javaType = Date.class, jdbcType = JdbcType.DATE),
            @Result(column = "endDate", property = "endDate", javaType = Date.class, jdbcType = JdbcType.DATE)
    })
    List<Theme> findAll(Theme theme);

    @Delete(value = "delete from theme where id=#{id}")
    void deleteById(@Param(value = "id") String id);

    @Insert(value = "INSERT INTO votesystem.theme (id, themeName, themeDate, endDate)VALUES(#{id}, #{themeName},#{themeDate},#{endDate})")
    Integer save(Theme theme);

    @Select("select * from theme where id=#{id} ")
    @ResultMap("resultMap")
    Theme findThemeByID(@Param("id") String id);
    @Update("update theme set themeName =#{themeName}，themeDate =#{themeDate}，tendDate = #{endDate} where id=#{id}")
    Integer updateThemeByID(Theme theme);
}
