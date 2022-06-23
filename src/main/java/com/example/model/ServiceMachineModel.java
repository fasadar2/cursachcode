package com.example.model;

public class ServiceMachineModel {
    private String id;
    private String message;
    private String serial;
    private String status;
    private String dos;
    private String dose;

    public ServiceMachineModel (String id,String message, String serial, String status,String dos,String dose){
        this.id = id;
        this.message = message;
        this.serial = serial;
        this.status = status;
        this.dos = dos;
        this.dose = dose;

    }
    public ServiceMachineModel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String name) {
        this.message = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }


}
