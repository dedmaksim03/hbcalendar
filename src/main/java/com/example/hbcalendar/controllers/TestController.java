package com.example.hbcalendar.controllers;

import com.example.hbcalendar.dtos.PersonDto;
import com.example.hbcalendar.model.Person;
import com.example.hbcalendar.service.PersonService;
import com.example.hbcalendar.service.UserService;
import com.example.hbcalendar.utils.JwtTokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test/")
@AllArgsConstructor
public class TestController {
    JwtTokenUtils jwtTokenUtils;
    PersonService personService;
    UserService userService;

    @GetMapping("/welcome")
    public String welcome(){
        return "This is unprotected page";
    }

    @GetMapping("/users")
    public String pageForUser(){
        return "This is page for only users";
    }


    @GetMapping("/admins")
    public String pageForAdmins(){
        return "This is page for only admins";
    }


    @GetMapping("/all")
    public String pageForAll(){
        return "This is page for all employees";
    }

    @GetMapping("/info")
    public ResponseEntity<?> userData(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        List<PersonDto> personsList = new ArrayList<>();
        for (Person person : personService.findAllByUser(userService.findByName(jwtTokenUtils.getUserName(token)).get())){
            personsList.add(new PersonDto(person.getName(), person.getDayOfBirth(), person.getMonthOfBirth()));
        }
        return ResponseEntity.ok(personsList);
    }

}
