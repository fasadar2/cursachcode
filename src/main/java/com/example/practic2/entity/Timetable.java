package com.example.practic2.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "timetable", schema = "medicalservice")
public class Timetable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private Instant date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "machineid", nullable = false)
    //todo имя поля (и ниже по коду) camelCase
    private Machine machineId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idpersonal", nullable = false)
    private Personal idPersonal;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idcabinet", nullable = false)
    private Cabinet idCabinet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Machine getMachineid() {
        return machineId;
    }

    public void setMachineid(Machine machineid) {
        this.machineId = machineid;
    }

    public Personal getIdpersonal() {
        return idPersonal;
    }

    public void setIdpersonal(Personal idpersonal) {
        this.idPersonal = idpersonal;
    }

    public Cabinet getIdcabinet() {
        return idCabinet;
    }

    public void setIdcabinet(Cabinet idcabinet) {
        this.idCabinet = idcabinet;
    }

}