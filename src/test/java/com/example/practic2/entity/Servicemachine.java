package com.example.practic2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Servicemachine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "engineerid")
    private Integer engineerid;
    @Basic
    @Column(name = "machineid")
    private Integer machineid;
    @Basic
    @Column(name = "errormessageid")
    private Integer errormessageid;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "dos")
    private Date dos;
    @Basic
    @Column(name = "dose")
    private Date dose;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEngineerid() {
        return engineerid;
    }

    public void setEngineerid(Integer engineerid) {
        this.engineerid = engineerid;
    }

    public Integer getMachineid() {
        return machineid;
    }

    public void setMachineid(Integer machineid) {
        this.machineid = machineid;
    }

    public Integer getErrormessageid() {
        return errormessageid;
    }

    public void setErrormessageid(Integer errormessageid) {
        this.errormessageid = errormessageid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDos() {
        return dos;
    }

    public void setDos(Date dos) {
        this.dos = dos;
    }

    public Date getDose() {
        return dose;
    }

    public void setDose(Date dose) {
        this.dose = dose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicemachine that = (Servicemachine) o;
        return Objects.equals(id, that.id) && Objects.equals(engineerid, that.engineerid) && Objects.equals(machineid, that.machineid) && Objects.equals(errormessageid, that.errormessageid) && Objects.equals(status, that.status) && Objects.equals(dos, that.dos) && Objects.equals(dose, that.dose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, engineerid, machineid, errormessageid, status, dos, dose);
    }
}
