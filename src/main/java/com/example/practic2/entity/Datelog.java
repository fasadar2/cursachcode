package com.example.practic2.entity;

import javax.persistence.*;

@Entity
@Table(name = "datelog", schema = "medicalservice")
public class Datelog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login", nullable = false, length = 20)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idpersonal", nullable = false)
    private Personal idpersonal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Personal getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Personal idpersonal) {
        this.idpersonal = idpersonal;
    }

}