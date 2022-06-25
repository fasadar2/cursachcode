package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recomendation {
    private String recomendation;
    private String serial;
    public Recomendation(@JsonProperty("recomendation") String recomendation,@JsonProperty("serial")String serial){
        this.recomendation = recomendation;
        this.serial = serial;
    }
    public Recomendation(){}
    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
