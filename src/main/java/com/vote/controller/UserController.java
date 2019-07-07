package com.vote.controller;

import com.vote.pojo.User;
import com.vote.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/register")
      public String register(User user,@RequestParam("province") String province,@RequestParam("city") String city,@RequestParam("counties") String counties){

        user.setAddress(province+city+counties+"");
        user.setId(UUID.randomUUID().toString());
        int i = userService.insUser(user);
        if(i>0){
         return "redirect:/login.jsp";
        }else{
            return "error";
        }

    }
}
