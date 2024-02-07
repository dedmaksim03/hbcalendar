package com.example.hbcalendar.controllers;

import com.example.hbcalendar.model.Person;
import com.example.hbcalendar.service.MonthService;
import com.example.hbcalendar.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final PersonService personService;
    private final MonthService monthService;

    @Autowired
    public PersonController(PersonService personService, MonthService monthService) {
        this.personService = personService;
        this.monthService = monthService;
    }

    @PostMapping("/persons/create")
    @ResponseBody
    public void create(@RequestBody Person person){
        personService.save(person);
        LOGGER.info(String.valueOf(person));
    }

    @GetMapping("/persons")
    public String read(Model model){
        model.addAttribute("persons", personService.findAll());
//        List<String> persons = new ArrayList<>();
//        for (Person person: personService.findAll()) {
//            persons.add(person.getName() + ": " + person.getDayOfBirth() + " " + monthService.getNameOfMonth(person.getMonthOfBirth()));
//        }
        return "persons";
    }

}
