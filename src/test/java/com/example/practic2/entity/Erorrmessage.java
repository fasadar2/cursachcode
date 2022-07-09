package com.example.practic2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Erorrmessage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "iddoctor")
    private Integer iddoctor;
    @Basic
    @Column(name = "machineid")
    private Integer machineid;
    @Basic
    @Column(name = "cabinetid")
    private Integer cabinetid;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "message")
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public Integer getMachineid() {
        return machineid;
    }

    public void setMachineid(Integer machineid) {
        this.machineid = machineid;
    }

    public Integer getCabinetid() {
        return cabinetid;
    }

    public void setCabinetid(Integer cabinetid) {
        this.cabinetid = cabinetid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Erorrmessage that = (Erorrmessage) o;
        return Objects.equals(id, that.id) && Objects.equals(iddoctor, that.iddoctor) && Objects.equals(machineid, that.machineid) && Objects.equals(cabinetid, that.cabinetid) && Objects.equals(date, that.date) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iddoctor, machineid, cabinetid, date, message);
    }
}
