package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewMachine {
    private String recomendation;
    private String machine;
    private String id;
    private String dateDEE;
    private String dateDSE;
    private String dateNTO;

    public NewMachine(
            @JsonProperty("machine") String machine ,@JsonProperty("id") String id,
            @JsonProperty("recomendation") String recomendation
            ,@JsonProperty("dateNTO") String dateNTO,
            @JsonProperty("dateDSE")String dateDSE,@JsonProperty("dateDEE") String dateDEE ){
        this.machine = machine;
        this.id = id;
        this.recomendation = recomendation;
        this.dateNTO = dateNTO;
        this.dateDSE = dateDSE;
        this.dateDEE = dateDEE;
    }
    public NewMachine(){}

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateDEE() {
        String subStr = dateDEE.substring(0, 10);
        return subStr;
    }

    public void setDateDEE(String dateDEE) {
        this.dateDEE = dateDEE;
    }

    public String getDateDSE() {
        String subStr = dateDSE.substring(0, 10);
        return subStr;
    }

    public void setDateDSE(String dateDSE) {
        this.dateDSE = dateDSE;
    }

    public String getDateNTO() {
        String subStr = dateNTO.substring(0, 10);
        return subStr;
    }

    public void setDateNTO(String dateNTO) {
        this.dateNTO = dateNTO;
    }
}
