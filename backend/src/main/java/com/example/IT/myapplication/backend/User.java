package com.example.IT.myapplication.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by IT on 18.10.2017.
 */
@Entity
public class User {

    @Id
    private Long id;
    private String name;
    private String surname;
    private String male;
    private int age;

    public User() {
    }

    public User(String name, String surname, String male, int age) {
        this.name = name;
        this.surname = surname;
        this.male = male;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMale() {
        return male;
    }

    public int getAge() {
        return age;
    }
}


