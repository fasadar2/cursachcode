package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MachineID {
    private String machine;
    private int is;
    public MachineID(@JsonProperty("machine")String machine,@JsonProperty("is") int is){

        this.machine = machine;
        this.is = is;
    }
    public MachineID(){}

    public String getMachineID() {
        return machine;
    }

    public void setID(String machineID) {
        this.machine = machineID;
    }

    public int getIs() {
        return is;
    }

    public void setIs(int is) {
        this.is = is;
    }
}
