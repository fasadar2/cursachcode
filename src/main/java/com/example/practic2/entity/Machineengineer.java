package com.example.practic2.entity;

import javax.persistence.*;

@Entity
@Table(name = "machineengineer", schema = "medicalservice")
public class Machineengineer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idmachine", nullable = false)
    //todo имя поля (и ниже по коду) camelCase
    private Machine idMachine;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idengineer", nullable = false)
    private Personal idEngineer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Machine getIdmachine() {
        return idMachine;
    }

    public void setIdmachine(Machine idmachine) {
        this.idMachine = idmachine;
    }

    public Personal getIdengineer() {
        return idEngineer;
    }

    public void setIdengineer(Personal idengineer) {
        this.idEngineer = idengineer;
    }

}