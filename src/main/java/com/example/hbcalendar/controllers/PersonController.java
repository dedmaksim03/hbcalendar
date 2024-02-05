package com.example.hbcalendar.controllers;

import com.example.hbcalendar.model.Person;
import com.example.hbcalendar.service.MonthService;
import com.example.hbcalendar.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    private final PersonService personService;
    private final MonthService monthService;

    @Autowired
    public PersonController(PersonService personService, MonthService monthService) {
        this.personService = personService;
        this.monthService = monthService;
    }

    @PostMapping("/persons/create")
    public void create(@RequestBody Person person){
        personService.save(person);
        LOGGER.info(String.valueOf(person));
    }

    @GetMapping("/persons")
    public List<String> read(){
        List<String> persons = new ArrayList<>();
        for (Person person: personService.findAll()) {
            persons.add(person.getName() + ": " + person.getDayOfBirth() + " " + monthService.getNameOfMonth(person.getMonthOfBirth()));
        }
        return persons;
    }

}
