package com.vote.service;

import com.vote.pojo.User;

public interface LoginService {
    public User login(String loginName,String password) throws Exception;
}
