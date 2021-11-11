package com.mvctask.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor extends User {

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @OneToMany(mappedBy="doctor")
    private Set<Record> records;

    public Doctor(String fullName, String phoneNumber, String email, String login, String password, Speciality speciality) {
        super(fullName, phoneNumber, email, login, password);
        this.speciality = speciality;
    }

    public Doctor() {

    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

}
