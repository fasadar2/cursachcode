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
    private Machine idmachine;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idengineer", nullable = false)
    private Personal idengineer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Machine getIdmachine() {
        return idmachine;
    }

    public void setIdmachine(Machine idmachine) {
        this.idmachine = idmachine;
    }

    public Personal getIdengineer() {
        return idengineer;
    }

    public void setIdengineer(Personal idengineer) {
        this.idengineer = idengineer;
    }

}