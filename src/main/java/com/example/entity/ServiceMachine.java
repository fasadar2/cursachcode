package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceMachine {
    private String status;
    private String id;
    private String errorid;
    private String ToES;
    private String ToSS;

    public ServiceMachine(
            @JsonProperty("status") String status,
            @JsonProperty("id") String id,
            @JsonProperty("errorid") String errorid,
            @JsonProperty("ToES") String ToES,
            @JsonProperty("ToSS") String ToSS
    ){
        this.status = status;
        this.id = id;
        this.errorid = errorid;
        this.ToES = ToES;
        this.ToSS = ToSS;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorid() {
        return errorid;
    }

    public void setErrorid(String errorid) {
        this.errorid = errorid;
    }

    public String getToES() {
        String subStr = ToES;
        if (!subStr.isEmpty()){
        subStr = ToES.substring(0, 10);}
        return subStr;
    }

    public void setToES(String toES) {
        ToES = toES;
    }

    public String getToSS() {
        String subStr = ToSS.substring(0, 10);
        return subStr;
    }

    public void setToSS(String toSS) {
        ToSS = toSS;
    }
}
