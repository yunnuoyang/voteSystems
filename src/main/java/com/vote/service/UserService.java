package com.vote.service;

import com.vote.pojo.User;

public interface UserService {
    // 注册用户
    public int insUser(User user);
    //修改用户
    public int updateUser(User user);
    //删除用户
    public  int deleteUser(User user);
}
