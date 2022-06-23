package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filter {
    private String date;
    public Filter(@JsonProperty("date")String date){
        this.date= date;
    }
    public Filter(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
