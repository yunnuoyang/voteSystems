package com.vote.repository;

import com.vote.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRepository {
      //用户注册
      public int register(User user);
      // 修改用户
      public int updUser(User user);
      //删除用户
      public  int delUser(User user);
      // 查询当前页用户列表
      public List<User>  findCurPage(int startPage,int pageSize);
      // 查询用户的总数
      public int userTotal();

      // 根据id 查询用户
       public  User findUserById(@Param("id") String id);
}
