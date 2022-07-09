package com.example.practic2.ReqestModel;

public class BasicReqestModel {
    private int code;
    private String message;
    public BasicReqestModel(int code,String message){
        this.code = code;
        this. message = message;
    }
    public BasicReqestModel(){}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
