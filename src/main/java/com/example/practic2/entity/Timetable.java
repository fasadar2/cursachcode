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
    private Machine machineid;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idpersonal", nullable = false)
    private Personal idpersonal;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idcabinet", nullable = false)
    private Cabinet idcabinet;

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
        return machineid;
    }

    public void setMachineid(Machine machineid) {
        this.machineid = machineid;
    }

    public Personal getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Personal idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Cabinet getIdcabinet() {
        return idcabinet;
    }

    public void setIdcabinet(Cabinet idcabinet) {
        this.idcabinet = idcabinet;
    }

}