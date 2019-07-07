package com.vote.pojo;

import lombok.Data;

@Data
public class User {
    private String id;
    private String loginName;
    private String realName;
    private String password;
    private char sex;
    private String address;
    // 用户身份
    private int status;

    public User(String id, String loginName, String realName, String password, char sex, String address, int status) {
        this.id = id;
        this.loginName = loginName;
        this.realName = realName;
        this.password = password;
        this.sex = sex;
        this.address = address;
        this.status = status;
    }
    public  User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
