package com.vote.service.Impl;

import com.vote.pojo.ResultData;
import com.vote.pojo.User;
import com.vote.repository.UserRepository;
import com.vote.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public ResultData findCurPage(int curPage, int pageSize) {
        ResultData resultData=new ResultData();
        resultData.setCount(userRepository.userTotal());
        resultData.setData(userRepository.findCurPage(curPage,pageSize));
        return resultData;
    }

    @Override
    public int uerTotal() {
        return userRepository.userTotal();
    }


}
