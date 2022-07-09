package com.example.practic2.ReqestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MachineRecomendationReqestModel {
    private Integer serial;
    private String recomendation;
    public MachineRecomendationReqestModel(@JsonProperty(value = "serial") Integer serial,@JsonProperty(value = "recomendation") String recomendation){
        this.serial = serial;
        this.recomendation = recomendation;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }
}
