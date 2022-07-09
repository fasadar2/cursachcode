package com.example.practic2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "machine", schema = "medicalservice", catalog = "medicalservice")
public class MachineEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "typeid")
    private int typeid;
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
    private int serial;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public void setTypeid(int typeid) {
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

    public int getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineEntity that = (MachineEntity) o;
        return id == that.id && typeid == that.typeid && serial == that.serial && Objects.equals(recommendation, that.recommendation) && Objects.equals(lastservice, that.lastservice) && Objects.equals(futerservice, that.futerservice) && Objects.equals(toE, that.toE) && Objects.equals(eToE, that.eToE) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeid, recommendation, lastservice, futerservice, toE, eToE, status, serial);
    }
}
