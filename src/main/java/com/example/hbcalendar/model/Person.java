package com.example.hbcalendar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private int yearOfBirth;

    public Person(String name, int yearOfBirth){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString(){
        return "{name: '" + name + "'" +
                ", yearOfBirth: '" + yearOfBirth + "'}";

    }
}
