package com.example.practic2.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Timetable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "machineid")
    private Integer machineid;
    @Basic
    @Column(name = "idpersonal")
    private Integer idpersonal;
    @Basic
    @Column(name = "idcabinet")
    private Integer idcabinet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getMachineid() {
        return machineid;
    }

    public void setMachineid(Integer machineid) {
        this.machineid = machineid;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getIdcabinet() {
        return idcabinet;
    }

    public void setIdcabinet(Integer idcabinet) {
        this.idcabinet = idcabinet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(id, timetable.id) && Objects.equals(date, timetable.date) && Objects.equals(machineid, timetable.machineid) && Objects.equals(idpersonal, timetable.idpersonal) && Objects.equals(idcabinet, timetable.idcabinet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, machineid, idpersonal, idcabinet);
    }
}
