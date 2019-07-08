package com.vote.repository;


import com.vote.pojo.Tickets;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface VoteRepository {
    /**
     * 用户投票
     */
    @Insert("INSERT INTO tickets(id,uid,tid,addData,ticketsType)\n" +
            "VALUES (#{id},#{uid},#{tid},#{addData},#{ticketsType})")
    public void addTicket(Tickets tickets);

    @Select("SELECT * FROM tickets WHERE uid = #{param1} AND tid = #{param2}")
    public Tickets findByUidAndTid(String uid,String tid);

}

