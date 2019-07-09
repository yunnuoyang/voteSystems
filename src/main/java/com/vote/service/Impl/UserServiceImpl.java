package com.vote.service.Impl;

import com.vote.pojo.ResultData;
import com.vote.pojo.User;
import com.vote.repository.UserRepository;
import com.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
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

    @Override
    public ResultData findCurPage(int curPage, int pageSize) {
        ResultData resultData=new ResultData();
        resultData.setCount(userRepository.userTotal());
        resultData.setData(userRepository.findCurPage((curPage-1)*pageSize,pageSize));
        return resultData;
    }

    @Override
    public int uerTotal() {
        return userRepository.userTotal();
    }

    @Override
    public User findUser(String id) {
        System.out.println("id:"+id);
        User user = userRepository.findUserById(id);
        return user;
    }
}
