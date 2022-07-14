package com.example.practic2.model;

import lombok.Builder;

import java.sql.Date;
import java.time.LocalDate;
@Builder
public class MachineListModel {
    private String type;
    private String recomendation;
    private LocalDate lastservice;
    private LocalDate futerservice;
    private LocalDate toe;
    private LocalDate etoe;
    private String status;
    private Integer serial;
    //todo используй шаблон Builder для удобного создания объектов этого класса


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public LocalDate getLastservice() {
        return lastservice;
    }

    public void setLastservice(LocalDate lastservice) {
        this.lastservice = lastservice;
    }

    public LocalDate getFuterservice() {
        return futerservice;
    }

    public void setFuterservice(LocalDate futerservice) {
        this.futerservice = futerservice;
    }

    public LocalDate getToe() {
        return toe;
    }

    public void setToe(LocalDate toe) {
        this.toe = toe;
    }

    public LocalDate getEtoe() {
        return etoe;
    }

    public void setEtoe(LocalDate etoe) {
        this.etoe = etoe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }
}
