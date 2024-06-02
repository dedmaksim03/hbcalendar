package com.example.hbcalendar.dtos;

import com.example.hbcalendar.entities.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class RegistrationUserDto {
    private String name;
    private String password;
    private String confirmPassword;
}
