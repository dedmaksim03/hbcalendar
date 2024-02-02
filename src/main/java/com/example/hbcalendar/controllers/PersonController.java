package com.example.hbcalendar.controllers;

import com.example.hbcalendar.model.Person;
import com.example.hbcalendar.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/persons")
    public void create(@RequestBody Person person){
        personService.create(person);
        LOGGER.info(String.valueOf(person));
        //return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/persons/{id}")
    public Person read(@PathVariable int id){
        return personService.read(id);
    }

}
