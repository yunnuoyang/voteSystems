package com.vote.service.Impl;

import com.vote.pojo.User;
import com.vote.repository.UserRepository;
import com.vote.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public int insUser(User user) {
        return userRepository.register(user);
    }

    @Override
    public int updateUser(User user) {
        return userRepository.updUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userRepository.delUser(user);
    }
}
