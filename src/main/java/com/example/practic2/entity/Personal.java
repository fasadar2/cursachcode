package com.example.practic2.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "personal", schema = "medicalservice")
public class Personal {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String firstname;

    @Column(name = "secondname", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String secondname;

    @Column(name = "thirdname")
    @Type(type = "org.hibernate.type.TextType")
    private String thirdname;

    @Column(name = "\"position\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String position;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}