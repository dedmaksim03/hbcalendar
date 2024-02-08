package com.example.hbcalendar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotNull
    @Length(max = 255)
    private String name;

    @Column(name = "day_of_birth")
    @NotNull
    private int dayOfBirth;

    @Column(name = "month_of_birth_id")
    @NotNull
    private int monthOfBirth;

    public Person(String name, int dayOfBirth, int monthOfBirth) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
    }

    @Override
    public String toString(){
        return "{name: '" + name + "'" +
                ", yearOfBirth: '" + dayOfBirth + "." + monthOfBirth + "'}";

    }
}
