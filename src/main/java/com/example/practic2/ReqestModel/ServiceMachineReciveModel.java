package com.example.practic2.ReqestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ServiceMachineReciveModel {
    private String status;
    private Integer machineId;
    private LocalDate TOEE;
    private LocalDate TOES;
    private Integer errorId;
    private Integer Id;

    public ServiceMachineReciveModel(
            @JsonProperty(value = "status") String status,
            @JsonProperty(value = "machineId")Integer machineId,
            @JsonProperty(value = "TOEE")LocalDate TOEE,
            @JsonProperty(value = "TOES")LocalDate TOES,
            @JsonProperty(value = "errorId")Integer errorId){
        this.machineId = machineId;
        this.status = status;
        this.errorId = errorId;
        this.TOEE = TOEE;
        this.TOES = TOES;
    }

    public ServiceMachineReciveModel(){}
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public LocalDate getTOEE() {
        return TOEE;
    }

    public void setTOEE(LocalDate TOEE) {
        this.TOEE = TOEE;
    }

    public LocalDate getTOES() {
        return TOES;
    }

    public void setTOES(LocalDate TOES) {
        this.TOES = TOES;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
