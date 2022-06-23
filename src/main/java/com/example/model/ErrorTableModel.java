package com.example.model;

public class ErrorTableModel {
    private String nameDoctor;
    private String machinenumber;
    private String cabinetNumber;
    private String date;
    private String message;

    public ErrorTableModel(String nameDoctor,String machinenumber,String cabinetNumber,String date,String message ){
        this.nameDoctor = nameDoctor;
        this.machinenumber = machinenumber;
        this.cabinetNumber = cabinetNumber;
        this.date = date;
        this.message = message;
    }
    public ErrorTableModel(){}

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public String getMachinenumber() {
        return machinenumber;
    }

    public void setMachinenumber(String machinenumber) {
        this.machinenumber = machinenumber;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
