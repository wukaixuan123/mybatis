package com.dao;

public class student {
    private int id;
    private String user_Name;
    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", user_Name='" + user_Name + '\'' +
                ", sexString='" + sexString + '\'' +
                ", sexStr='" + sexStr + '\'' +
                '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getSexString() {
        return sexString;
    }

    public void setSexString(String sexString) {
        this.sexString = sexString;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    private String sexString;
    private String sexStr;

}
