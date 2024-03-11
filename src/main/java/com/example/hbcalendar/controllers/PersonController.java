package com.example.hbcalendar.controllers;

import com.example.hbcalendar.model.Person;
import com.example.hbcalendar.service.MonthService;
import com.example.hbcalendar.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private PersonService personService;
    @Autowired
    private MonthService monthService;

    @PostMapping("/api/v1/persons/create")
    @ResponseBody
    public ResponseEntity<Person> create(@RequestBody Person newPerson){
        personService.save(newPerson);
        return new ResponseEntity<Person>(newPerson, HttpStatus.CREATED);
    }

    @PostMapping("/api/v1/persons/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam String name){
        personService.delete(name);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @GetMapping("/api/v1/persons")
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id){
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

}
