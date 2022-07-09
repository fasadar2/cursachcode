package com.example.practic2.ReqestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class MachineReciveModel {
    private String type;
    private LocalDate DSE;
    private LocalDate DEE;
    private String recomendation;
    private LocalDate dateNTO;
    private Integer serial;

    public MachineReciveModel(
            @JsonProperty(value = "type") String type,
            @JsonProperty(value = "recomendation") String recomendation,
            @JsonProperty(value = "DSE") LocalDate DSE,
            @JsonProperty(value = "DEE") LocalDate DEE,
            @JsonProperty(value = "serial") Integer serial,
            @JsonProperty(value = "dateNTO") LocalDate dateNTO
    ){
        this.dateNTO = dateNTO;
        this.DEE = DEE;
        this.DSE = DSE;
        this.recomendation = recomendation;
        this.type = type;
        this.serial = serial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDSE() {
        return DSE;
    }

    public void setDSE(LocalDate DSE) {
        this.DSE = DSE;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public LocalDate getDEE() {
        return DEE;
    }

    public void setDEE(LocalDate DEE) {
        this.DEE = DEE;
    }

    public LocalDate getDateNTO() {
        return dateNTO;
    }

    public void setDateNTO(LocalDate dateNTO) {
        this.dateNTO = dateNTO;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }
}
