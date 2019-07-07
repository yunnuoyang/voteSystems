package com.vote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vote")
public class VoteController {

    @GetMapping("/addTicket/{uid}/{tid}/{ticketsType}")
    public String addTicket(@PathVariable("uid") String uid,@PathVariable("tid") String tid,@PathVariable("ticketsType") int ticketsType){

        return "";
    }
}
