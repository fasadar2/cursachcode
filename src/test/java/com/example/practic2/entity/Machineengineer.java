package com.example.practic2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Machineengineer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "machineid")
    private Integer machineid;
    @Basic
    @Column(name = "engineerid")
    private Integer engineerid;
    @Basic
    @Column(name = "machine")
    private Integer machine;
    @Basic
    @Column(name = "engineeri")
    private Integer engineeri;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMachineid() {
        return machineid;
    }

    public void setMachineid(Integer machineid) {
        this.machineid = machineid;
    }

    public Integer getEngineerid() {
        return engineerid;
    }

    public void setEngineerid(Integer engineerid) {
        this.engineerid = engineerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machineengineer that = (Machineengineer) o;
        return Objects.equals(id, that.id) && Objects.equals(machineid, that.machineid) && Objects.equals(engineerid, that.engineerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, machineid, engineerid);
    }

    public Integer getMachine() {
        return machine;
    }

    public void setMachine(Integer machine) {
        this.machine = machine;
    }

    public Integer getEngineeri() {
        return engineeri;
    }

    public void setEngineeri(Integer engineeri) {
        this.engineeri = engineeri;
    }
}
