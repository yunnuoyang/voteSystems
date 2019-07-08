package com.vote.controller;

import com.vote.pojo.User;
import com.vote.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public String login(String loginName, String password, Model model) throws Exception{
        ModelAndView modelAndView=new ModelAndView();

        try {
            User user=loginService.login(loginName, password);
            model.addAttribute("user",user);
            return "main";
        }catch (Exception e){
            if(e.getMessage().equals("用户名或者密码错误！")){
                model.addAttribute("err",e.getMessage());
                return "login";
            }else{
                e.printStackTrace();
            }
        }
        return "";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
