package com.vote.service;

import com.vote.pojo.ResultData;
import com.vote.pojo.User;

import java.util.List;

public interface UserService {
    // 注册用户
    public int insUser(User user);
    //修改用户
    public int updateUser(User user);
    //删除用户
    public  int deleteUser(User user);
    // 查询当前页用户
    public ResultData findCurPage(int curPage,int pageSize);
    // 查询用户总数
    public  int  uerTotal();
}
