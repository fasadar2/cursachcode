package com.example.practic2.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "timetable", schema = "medicalservice", catalog = "medicalservice")
public class TimetableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    @Basic
    @Column(name = "machineid", nullable = false)
    private int machineid;
    @Basic
    @Column(name = "idpersonal", nullable = false)
    private int idpersonal;
    @Basic
    @Column(name = "idcabinet", nullable = false)
    private int idcabinet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getMachineid() {
        return machineid;
    }

    public void setMachineid(int machineid) {
        this.machineid = machineid;
    }

    public int getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
    }

    public int getIdcabinet() {
        return idcabinet;
    }

    public void setIdcabinet(int idcabinet) {
        this.idcabinet = idcabinet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimetableEntity that = (TimetableEntity) o;
        return id == that.id && machineid == that.machineid && idpersonal == that.idpersonal && idcabinet == that.idcabinet && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, machineid, idpersonal, idcabinet);
    }
}
