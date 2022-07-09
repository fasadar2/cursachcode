package com.example.practic2.ReqestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ServiceMachineUpdateReciveModel {
    private String status;
    private Integer id;
    private LocalDate TOES;
    public ServiceMachineUpdateReciveModel(
            @JsonProperty(value = "status") String status,
            @JsonProperty(value = "id") Integer id,
            @JsonProperty(value = "TOES") LocalDate TOES
    ){
        this.status = status;
        this.id = id;
        this.TOES = TOES;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getTOES() {
        return TOES;
    }

    public void setTOES(LocalDate TOES) {
        this.TOES = TOES;
    }
}
