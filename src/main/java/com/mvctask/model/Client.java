package com.mvctask.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "clients")
public class Client extends User {

    @OneToMany(mappedBy="client")
    private Set<Record> records;

    public Client(String fullName, String phoneNumber,String email, String login, String password) {
        super(fullName, phoneNumber, email, login, password);
    }

    public  Client(){

    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

}
