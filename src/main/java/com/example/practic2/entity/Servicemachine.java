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
    private Personal engineerid;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "machineid", nullable = false)
    private Machine machineid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "errormessageid")
    private Erorrmessage errormessageid;

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
        return engineerid;
    }

    public void setEngineerid(Personal engineerid) {
        this.engineerid = engineerid;
    }

    public Machine getMachineid() {
        return machineid;
    }

    public void setMachineid(Machine machineid) {
        this.machineid = machineid;
    }

    public Erorrmessage getErrormessageid() {
        return errormessageid;
    }

    public void setErrormessageid(Erorrmessage errormessageid) {
        this.errormessageid = errormessageid;
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