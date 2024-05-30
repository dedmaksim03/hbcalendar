package com.example.hbcalendar.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("test/")
@AllArgsConstructor
public class TestController {

    @GetMapping("/welcome")
    public String welcome(){
        return "This is unprotected page";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority(1)")
    public String pageForUser(){
        return "This is page for only users";
    }


    @GetMapping("/admins")
    @PreAuthorize("hasAuthority(2)")
    public String pageForAdmins(){
        return "This is page for only admins";
    }


    @GetMapping("/all")
    public String pageForAll(){
        return "This is page for all employees";
    }

    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }

}
