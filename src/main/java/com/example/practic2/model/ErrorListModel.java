package com.example.practic2.model;

import java.time.LocalDate;

public class ErrorListModel {
    private String firstname;
    private String secondname;
    private String thirdname;
    private Integer id;
    private String cabinetnumber;
    private LocalDate date;
    private Integer serial;
    private String message;

    public ErrorListModel(String firstname,String secondname,String thirdname,Integer id,String cabinetnumber,LocalDate date,Integer serial, String message){
        this.firstname = firstname;
        this.secondname = secondname;
        this.thirdname = thirdname;
        this.id = id;
        this.cabinetnumber = cabinetnumber;
        this.date = date;
        this.serial = serial;
        this.message = message;
    }
    public ErrorListModel(){}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCabinetnumber() {
        return cabinetnumber;
    }

    public void setCabinetnumber(String cabinetnumber) {
        this.cabinetnumber = cabinetnumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}