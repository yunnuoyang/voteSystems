package com.vote.service.Impl;

import com.vote.pojo.User;
import com.vote.repository.LoginRepository;
import com.vote.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Override
    public User login(String loginName, String password) throws Exception {
        User user=loginRepository.login(loginName, password);
        if(user!=null){
            return user;
        }else{
            throw new Exception("用户名或者密码错误！");
        }

    }
}
