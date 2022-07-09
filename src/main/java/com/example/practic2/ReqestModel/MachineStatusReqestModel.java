package com.example.practic2.ReqestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MachineStatusReqestModel {
    private String status;
    private Integer serial;

    public MachineStatusReqestModel(@JsonProperty(value = "status")  String status,@JsonProperty (value = "serial") Integer serial){
        this.status = status;
        this.serial = serial;
    }
    public MachineStatusReqestModel(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }
}
