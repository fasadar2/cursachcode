package com.example.entity;

import jakarta.inject.Singleton;


public class Accauntt {
    private String log;
    private String password;

    public Accauntt(String log, String password){
        this.log = log;
        this.password = password;
    }
    public Accauntt(){}

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
