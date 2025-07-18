package com.itheima.beans;

import java.util.Collections;
import java.util.HashMap;

public class User {
    private String userName;
    private String password;

    public User(){}

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", password=" + password + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        return this.getUserName().equals(((User)obj).getUserName()) && this.getPassword().equals(((User)obj).getPassword());
    }
}
