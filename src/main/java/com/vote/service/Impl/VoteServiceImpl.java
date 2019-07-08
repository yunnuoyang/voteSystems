package com.vote.service.Impl;

import com.vote.pojo.Tickets;
import com.vote.repository.VoteRepository;
import com.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public boolean addTicket(Tickets tickets) {
        boolean flag = false;
        //判断投票是否有效，并且投票时间在截至日期之前
        //通过获取该主题的截至时间
        //...
        Date end = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            end = sdf.parse("2019-7-25");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //获取投票时间
        Date now = tickets.getAddData();

        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(now);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);

        if(endCalendar.after(nowCalendar)){
            flag = true;
            //在截至时间之前，可以投票，将投票记录存入数据表中
            voteRepository.addTicket(tickets);
        }

        return flag;
    }

    @Override
    public Tickets findByUidAndTid(String uid, String tid) {

        Tickets alreadyVote = voteRepository.findByUidAndTid(uid, tid);

        return alreadyVote;
    }
}

