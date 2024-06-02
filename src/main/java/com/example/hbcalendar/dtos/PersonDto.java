package com.example.hbcalendar.dtos;

import com.example.hbcalendar.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class PersonDto {
    private String name;
    private int dayOfBirth;
    private int monthOfBirth;
}
