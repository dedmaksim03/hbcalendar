package com.example.hbcalendar.model;

import com.example.hbcalendar.entities.User;
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

    @Column(name = "month_of_birth")
    @NotNull
    private int monthOfBirth;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString(){
        return "{name: '" + name + "'" +
                ", yearOfBirth: '" + dayOfBirth + "." + monthOfBirth + "'}";

    }
}
