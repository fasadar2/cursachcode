package com.example.practic2.model;

import java.time.LocalDate;

public class ServiceMachineListModel {
    private String firstName;
    private String secondName;
    private String thirdName;
    private Integer serial;

    private Integer id;
    private String status;
    private LocalDate dos;
    private LocalDate dose;

    public ServiceMachineListModel(String firstName,String secondName,String thirdName,Integer serial,Integer id,String status,LocalDate dos, LocalDate dose){
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.serial = serial;

        this.id = id;
        this.status = status;
        this.dos = dos;
        this.dose = dose;
    }
    public ServiceMachineListModel(){}

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

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDos() {
        return dos;
    }

    public void setDos(LocalDate dos) {
        this.dos = dos;
    }

    public LocalDate getDose() {
        return dose;
    }

    public void setDose(LocalDate dose) {
        this.dose = dose;
    }
}
