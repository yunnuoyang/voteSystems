package com.vote.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 计算日期间隔的类
 */
public class DateCal {
    /**
     *
     * @param date 初始发布日期
     * @param d2    投票截止日期
     * @return   日期的期限天数
     */
    public static int getDate(Date date,Date d2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //今天的日期
        int startDate = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) );//让日期加1
//        System.out.println(calendar.get(Calendar.DATE));//加1之后的日期Top
        calendar.setTime(d2);
        int endDate = calendar.get(Calendar.DATE);
        return endDate-startDate;
    }

    public static void main(String[] args) {
        int date = DateCal.getDate(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        System.out.println(date);
    }
}
