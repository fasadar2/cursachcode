package com.example.practic2.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "machine", schema = "medicalservice")
public class Machine {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue()
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "typeid", nullable = false)
    private Machinetype typeid;

    @Column(name = "recommendation", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String recommendation;

    @Column(name = "lastservice")
    private LocalDate lastservice;

    @Column(name = "futerservice", nullable = false)
    private LocalDate futerservice;

    @Column(name = "toe", nullable = false)
    private LocalDate toe;

    @Column(name = "etoe", nullable = false)
    private LocalDate etoe;

    @Column(name = "status")
    @Type(type = "org.hibernate.type.TextType")
    private String status;

    @Column(name = "serial", nullable = false)
    private Integer serial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Machinetype getTypeid() {
        return typeid;
    }

    public void setTypeid(Machinetype typeid) {
        this.typeid = typeid;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public LocalDate getLastservice() {
        return lastservice;
    }

    public void setLastservice(LocalDate lastservice) {
        this.lastservice = lastservice;
    }

    public LocalDate getFuterservice() {
        return futerservice;
    }

    public void setFuterservice(LocalDate futerservice) {
        this.futerservice = futerservice;
    }

    public LocalDate getToe() {
        return toe;
    }

    public void setToe(LocalDate toe) {
        this.toe = toe;
    }

    public LocalDate getEtoe() {
        return etoe;
    }

    public void setEtoe(LocalDate etoe) {
        this.etoe = etoe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

}