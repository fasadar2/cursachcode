package com.example.practic2.ReqestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginReqestModel {
    private String login;
    private String password;

    public LoginReqestModel (@JsonProperty("login") String login,@JsonProperty("password") String password){
        this.login = login;
        this.password = password;

    }
    public LoginReqestModel(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
