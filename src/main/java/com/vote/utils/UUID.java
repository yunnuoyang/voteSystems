package com.vote.utils;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class UUID {
    public static String getUUID() {
        String[] split = java.util.UUID.randomUUID().toString().split("-");
        String target="";
        for (String s:
             split) {
            target+=s;
        }
        return target;
    }

    public static void main(String[] args) {
        String uuid = UUID.getUUID();
        System.out.println(uuid);
    }
}
