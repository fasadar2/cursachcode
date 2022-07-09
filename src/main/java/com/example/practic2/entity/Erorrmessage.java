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
    private Personal iddoctor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "machineid", nullable = false)
    private Machine machineid;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cabinetid", nullable = false)
    private Cabinet cabinetid;

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
        return iddoctor;
    }

    public void setIddoctor(Personal iddoctor) {
        this.iddoctor = iddoctor;
    }

    public Machine getMachineid() {
        return machineid;
    }

    public void setMachineid(Machine machineid) {
        this.machineid = machineid;
    }

    public Cabinet getCabinetid() {
        return cabinetid;
    }

    public void setCabinetid(Cabinet cabinetid) {
        this.cabinetid = cabinetid;
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