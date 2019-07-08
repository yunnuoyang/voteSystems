package com.vote.repository;

import com.vote.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository {
    public User login(String loginName,String password);
}
