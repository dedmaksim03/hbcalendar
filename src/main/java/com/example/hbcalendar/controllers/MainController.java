package com.example.hbcalendar.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class MainController {

//    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

//    @PostMapping("/persons")
//    public void addPerson(@Valid @RequestBody AddPersonDTO addPersonDTO){
//        LOGGER.info("Create user request received: {}", addPersonDTO);
//    }

//    @PostMapping("/persons")
//    public void addPerson(){
//        LOGGER.info("Create user request received:");
//    }
//
//    @Value("${spring.application.name}")
//    private String name;

    @GetMapping("/")
    public String getStartApplication(){
        return "index";
    }
//
//    @GetMapping("/{name}")
//    public String getStartApplicationWithName(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }
//
//    @GetMapping("/get_id")
//    public int getId(@RequestParam(value = "id") int id){
//        return id;
//    }
//
//    @GetMapping("/name")
//    public String getNameApplication(){
//        return name;
//    }
}
