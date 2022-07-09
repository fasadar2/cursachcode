package com.example.practic2.ReqestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class MachineTOUpdateRequestModel {
    private Integer serial;
    private LocalDate date;
    public MachineTOUpdateRequestModel(@JsonProperty(value = "serial") Integer serial,@JsonProperty(value = "date") LocalDate date){
        this.serial = serial;
        this.date = date;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
