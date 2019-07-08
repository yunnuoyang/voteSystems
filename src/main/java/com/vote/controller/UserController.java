package com.vote.controller;

import com.vote.pojo.User;
import com.vote.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
      public String register(User user,@RequestParam("province") String province,@RequestParam("city") String city,@RequestParam("counties") String counties){
        user.setAddress(province+city+counties+"");
        user.setId(UUID.randomUUID().toString());
        int i = userService.insUser(user);
        if(i>0){
        return "success";
        }else{
        return "error";
        }
    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(User user,@RequestParam("province") String province,@RequestParam("city") String city,@RequestParam("counties") String counties){
        user.setAddress(province+city+counties+"");
        int i = userService.updateUser(user);
        return "redirect:/main.jsp";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(String id){
        User user=new User();
        user.setId(id);
        int i = userService.deleteUser(user);
        return "redirect:/main.jsp";
    }
}
