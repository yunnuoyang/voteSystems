package com.vote.service;

import com.vote.pojo.Tickets;

public interface VoteService {

    public boolean addTicket(Tickets tickets);

    public Tickets findByUidAndTid(String uid,String tid);
}
