package com.example.practic2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "personal", schema = "medicalservice", catalog = "medicalservice")
public class PersonalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "firstname", nullable = false, length = -1)
    private String firstname;
    @Basic
    @Column(name = "secondname", nullable = false, length = -1)
    private String secondname;
    @Basic
    @Column(name = "thirdname", nullable = true, length = -1)
    private String thirdname;
    @Basic
    @Column(name = "position", nullable = false, length = -1)
    private String position;
    @Basic
    @Column(name = "dob", nullable = false)
    private Date dob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalEntity that = (PersonalEntity) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(secondname, that.secondname) && Objects.equals(thirdname, that.thirdname) && Objects.equals(position, that.position) && Objects.equals(dob, that.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, secondname, thirdname, position, dob);
    }
}
