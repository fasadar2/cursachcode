package com.example.practic2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Machine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "typeid")
    private Integer typeid;
    @Basic
    @Column(name = "recommendation")
    private String recommendation;
    @Basic
    @Column(name = "lastservice")
    private Date lastservice;
    @Basic
    @Column(name = "futerservice")
    private Date futerservice;
    @Basic
    @Column(name = "ToE")
    private Date toE;
    @Basic
    @Column(name = "EToE")
    private Date eToE;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "serial")
    private Integer serial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Date getLastservice() {
        return lastservice;
    }

    public void setLastservice(Date lastservice) {
        this.lastservice = lastservice;
    }

    public Date getFuterservice() {
        return futerservice;
    }

    public void setFuterservice(Date futerservice) {
        this.futerservice = futerservice;
    }

    public Date getToE() {
        return toE;
    }

    public void setToE(Date toE) {
        this.toE = toE;
    }

    public Date geteToE() {
        return eToE;
    }

    public void seteToE(Date eToE) {
        this.eToE = eToE;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machine machine = (Machine) o;
        return Objects.equals(id, machine.id) && Objects.equals(typeid, machine.typeid) && Objects.equals(recommendation, machine.recommendation) && Objects.equals(lastservice, machine.lastservice) && Objects.equals(futerservice, machine.futerservice) && Objects.equals(toE, machine.toE) && Objects.equals(eToE, machine.eToE) && Objects.equals(status, machine.status) && Objects.equals(serial, machine.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeid, recommendation, lastservice, futerservice, toE, eToE, status, serial);
    }
}
