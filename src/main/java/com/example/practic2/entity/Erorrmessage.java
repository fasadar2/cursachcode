package com.example.practic2.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "erorrmessage", schema = "medicalservice")
public class Erorrmessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "iddoctor", nullable = false)
    //todo имя поля (и ниже по коду) camelCase
    private Personal idDoctor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "machineid", nullable = false)
    private Machine machineId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cabinetid", nullable = false)
    private Cabinet cabinetId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "message", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Personal getIddoctor() {
        return idDoctor;
    }

    public void setIddoctor(Personal iddoctor) {
        this.idDoctor = iddoctor;
    }

    public Machine getMachineid() {
        return machineId;
    }

    public void setMachineid(Machine machineid) {
        this.machineId = machineid;
    }

    public Cabinet getCabinetid() {
        return cabinetId;
    }

    public void setCabinetid(Cabinet cabinetid) {
        this.cabinetId = cabinetid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}