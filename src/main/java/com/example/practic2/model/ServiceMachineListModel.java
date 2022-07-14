package com.example.practic2.model;

import lombok.Builder;

import java.time.LocalDate;
@Builder

public class ServiceMachineListModel {
    private String firstName;
    private String secondName;
    private String thirdName;
    private Integer serial;

    private Integer id;
    private String status;
    private LocalDate dos;
    private LocalDate dose;
    //
    // todo используй шаблон Builder для удобного создания объектов этого класса



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
