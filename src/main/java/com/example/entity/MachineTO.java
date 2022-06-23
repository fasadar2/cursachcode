package com.example.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MachineTO {
    private String serial;
    private String lastTO;
    public MachineTO(@JsonProperty("lastTO")String lastTO, @JsonProperty("id")String serial){
        this.serial = serial;
        this.lastTO = lastTO;
    }
    public MachineTO(){}

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getLastTO() {
        String subStr = lastTO.substring(0, 10);
        return subStr;
    }

    public void setLastTO(String lastTO) {
        this.lastTO = lastTO;
    }
}
