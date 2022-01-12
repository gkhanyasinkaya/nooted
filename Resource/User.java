package com.app.nooted.Resource;

public class User {

    private int id;
    private int workSpaceId;
    private String userName;
    private String userMail;
    private String userPass;

    public User(){}

    public User(int id, int workSpaceId, String userName, String userMail, String userPass) {
        this.id = id;
        this.workSpaceId = workSpaceId;
        this.userName = userName;
        this.userMail = userMail;
        this.userPass = userPass;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkSpaceId() {
        return workSpaceId;
    }

    public void setWorkSpaceId(int workSpaceId) {
        this.workSpaceId = workSpaceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }


}