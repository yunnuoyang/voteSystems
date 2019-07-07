package com.vote.repository;


public interface VoteRepository {
    /**
     * 用户投票
     * @param uid:用户id
     * @param tid:主题id
     * @param ticketsType: 投赞成票1，反对票0
     */
    public void addTicket(String uid,String tid,int ticketsType);

}
