package com.vote.controller;

import com.vote.pojo.Tickets;
import com.vote.pojo.User;
import com.vote.service.VoteService;
import com.vote.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("/addTicket/{tid}/{ticketsType}")
    @ResponseBody
    public String addTicket(HttpSession session, @PathVariable("tid") String tid, @PathVariable("ticketsType") int ticketsType) throws ParseException {
        System.out.println("---->进入controller");
        //通过session获取当前用户的id
        User user = (User) session.getAttribute("user");
        //将投票信息封装成对象，传给service
        Tickets tickets = new Tickets();
        tickets.setId(UUID.getUUID());
        tickets.setUid(user.getId());
        tickets.setTid(tid);
        tickets.setAddData(new Date());
        tickets.setTicketsType(ticketsType);
        //判断是否已经投过票
        Tickets alreadyVote = voteService.findByUidAndTid(user.getId(), tid);
        if(alreadyVote!=null){
            return "alreadyVote";
        }else {
            boolean flag = voteService.addTicket(tickets);
            if(flag){
                //投票未逾期
                System.out.println("未逾期");
                return "success";
            }else{
                //投票逾期
                System.out.println("逾期");
                return "fail";
            }
        }

    }
}
