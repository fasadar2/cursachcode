package com.example.practic2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "erorrmessage", schema = "medicalservice", catalog = "medicalservice")
public class ErorrmessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "iddoctor", nullable = false)
    private int iddoctor;
    @Basic
    @Column(name = "machineid", nullable = false)
    private int machineid;
    @Basic
    @Column(name = "cabinetid", nullable = false)
    private int cabinetid;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "message", nullable = false, length = -1)
    private String message;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public int getMachineid() {
        return machineid;
    }

    public void setMachineid(Integer machineid) {
        this.machineid = machineid;
    }

    public void setMachineid(int machineid) {
        this.machineid = machineid;
    }

    public int getCabinetid() {
        return cabinetid;
    }

    public void setCabinetid(Integer cabinetid) {
        this.cabinetid = cabinetid;
    }

    public void setCabinetid(int cabinetid) {
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
        ErorrmessageEntity that = (ErorrmessageEntity) o;
        return id == that.id && iddoctor == that.iddoctor && machineid == that.machineid && cabinetid == that.cabinetid && Objects.equals(date, that.date) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iddoctor, machineid, cabinetid, date, message);
    }
}
