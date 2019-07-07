package com.vote.utils;

import org.springframework.stereotype.Component;
public class UUID {
    public static String getUUID(){
        return java.util.UUID.randomUUID().toString().split("-").toString();
    }
}
