package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Email {
    private String Email;
    public Email(@JsonProperty("email")String Email){
        this.Email = Email;
    }
    public Email(){}

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
