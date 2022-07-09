package com.example.practic2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "servicemachine", schema = "medicalservice", catalog = "medicalservice")
public class ServicemachineEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "engineerid", nullable = false)
    private int engineerid;
    @Basic
    @Column(name = "machineid", nullable = false)
    private int machineid;
    @Basic
    @Column(name = "errormessageid", nullable = true)
    private Integer errormessageid;
    @Basic
    @Column(name = "status", nullable = true, length = -1)
    private String status;
    @Basic
    @Column(name = "dos", nullable = false)
    private Date dos;
    @Basic
    @Column(name = "dose", nullable = true)
    private Date dose;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEngineerid() {
        return engineerid;
    }

    public void setEngineerid(Integer engineerid) {
        this.engineerid = engineerid;
    }

    public void setEngineerid(int engineerid) {
        this.engineerid = engineerid;
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
        ServicemachineEntity that = (ServicemachineEntity) o;
        return id == that.id && engineerid == that.engineerid && machineid == that.machineid && Objects.equals(errormessageid, that.errormessageid) && Objects.equals(status, that.status) && Objects.equals(dos, that.dos) && Objects.equals(dose, that.dose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, engineerid, machineid, errormessageid, status, dos, dose);
    }
}
