package com.vote.controller;

import com.vote.pojo.ResultData;
import com.vote.pojo.User;
import com.vote.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
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
        user.setId(com.vote.utils.UUID.getUUID());
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
    @ResponseBody
    public String updateUser(User user,@RequestParam("province") String province,@RequestParam("city") String city,@RequestParam("counties") String counties){
        user.setAddress(province+city+counties+"");
        int i = userService.updateUser(user);
       if(i>0){
          return "success";
       }else{
           return "error";
       }
    }

    /**
     * 删除用户
     * @param uid
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam("uid") String uid){
        User user=new User();
        user.setId(uid);
        int i = userService.deleteUser(user);
         if(i>0){
        return "success";
          }else{
             return "error";
         }
    }
    //用户列表
    @RequestMapping("/userList")
    @ResponseBody
    public ResultData findAll(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int limit){
        ResultData all = userService.findCurPage(page, limit);
        all.setCode(0);
        all.setMsg("");
        return all;
    }

    // 根据id  查询用户
    @RequestMapping("/findUser")
    public ModelAndView findUser(String uid){
        ModelAndView modelAndView=new ModelAndView();
        User user = userService.findUser(uid);
        System.out.println(user);
        if(user!=null){
             modelAndView.setViewName("updateUser");
             modelAndView.addObject("user",user);

        }else{
            modelAndView.setViewName("welcome");
        }
         return  modelAndView;
    }
}
