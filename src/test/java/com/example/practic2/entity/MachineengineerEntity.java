package com.example.practic2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "machineengineer", schema = "medicalservice", catalog = "medicalservice")
public class MachineengineerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "machineid", nullable = false)
    private int machineid;
    @Basic
    @Column(name = "engineerid", nullable = false)
    private int engineerid;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getEngineerid() {
        return engineerid;
    }

    public void setEngineerid(Integer engineerid) {
        this.engineerid = engineerid;
    }

    public void setEngineerid(int engineerid) {
        this.engineerid = engineerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineengineerEntity that = (MachineengineerEntity) o;
        return id == that.id && machineid == that.machineid && engineerid == that.engineerid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, machineid, engineerid);
    }
}
