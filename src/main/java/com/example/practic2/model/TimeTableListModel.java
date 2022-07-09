package com.example.practic2.model;

import java.time.Instant;

public class TimeTableListModel {
    private String cabinetNumber;
    private String firstName;
    private String secondName;
    private String thirdName;
    private Instant date;
    private String typeMachine;

    public TimeTableListModel(String cabinetNumber,String firstName,String secondName,String thirdName,Instant date,String typeMachine){
        this.cabinetNumber = cabinetNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.date = date;
        this.typeMachine = typeMachine;
    }
    public TimeTableListModel(){}

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getTypeMachine() {
        return typeMachine;
    }

    public void setTypeMachine(String typeMachine) {
        this.typeMachine = typeMachine;
    }
}
