package com.vote.service.Impl;

import com.vote.repository.VoteRepository;
import com.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public void addTicket(String uid, String tid, int ticketsType) {
        //判断投票是否有效，并且投票时间在截至日期之前
        voteRepository.addTicket(uid,tid,ticketsType);
    }
}
