package com.example.hbcalendar.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController implements ErrorController {

    private static final String PATH = "/error";
    @GetMapping("/")
    public String getStartApplication(){
        return "index";
    }

    @RequestMapping(value = PATH)
    @ResponseBody
    public String error(){
        return "Error... Kapzda";
    }
}
