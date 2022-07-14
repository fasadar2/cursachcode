package com.example.practic2.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "servicemachine", schema = "medicalservice")
public class Servicemachine {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue()
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "engineerid", nullable = false)
    //todo имя поля (и ниже по коду) camelCase
    private Personal engineerId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "machineid", nullable = false)
    private Machine machineId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "errormessageid")
    private Erorrmessage errorMessageid;

    @Column(name = "status")
    @Type(type = "org.hibernate.type.TextType")
    private String status;

    @Column(name = "dos", nullable = false)
    private LocalDate dos;

    @Column(name = "dose")
    private LocalDate dose;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Personal getEngineerid() {
        return engineerId;
    }

    public void setEngineerid(Personal engineerid) {
        this.engineerId = engineerid;
    }

    public Machine getMachineid() {
        return machineId;
    }

    public void setMachineid(Machine machineid) {
        this.machineId = machineid;
    }

    public Erorrmessage getErrormessageid() {
        return errorMessageid;
    }

    public void setErrormessageid(Erorrmessage errormessageid) {
        this.errorMessageid = errormessageid;
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