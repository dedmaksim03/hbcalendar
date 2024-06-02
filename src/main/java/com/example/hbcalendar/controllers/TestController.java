package com.example.hbcalendar.controllers;

import com.example.hbcalendar.utils.JwtTokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("test/")
@AllArgsConstructor
public class TestController {
    JwtTokenUtils jwtTokenUtils;

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
    public String userData(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        return jwtTokenUtils.getUserName(token);
    }

}
