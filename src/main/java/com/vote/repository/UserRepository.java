package com.vote.repository;

import com.vote.pojo.User;

public interface UserRepository {
      //用户注册
      public int register(User user);
      // 修改用户
      public int updUser(User user);
      //删除用户
      public  int delUser(User user);
}
