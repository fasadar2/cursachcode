package com.example.practic2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Datelog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "idpersonal")
    private Integer idpersonal;

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

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datelog datelog = (Datelog) o;
        return Objects.equals(id, datelog.id) && Objects.equals(login, datelog.login) && Objects.equals(password, datelog.password) && Objects.equals(idpersonal, datelog.idpersonal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, idpersonal);
    }
}
