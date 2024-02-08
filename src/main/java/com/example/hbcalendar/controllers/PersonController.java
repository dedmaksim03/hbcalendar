package com.example.hbcalendar.controllers;

import com.example.hbcalendar.model.Person;
import com.example.hbcalendar.service.MonthService;
import com.example.hbcalendar.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

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
    public ModelAndView create(@RequestParam String name, int dayOfBirth, int monthOfBirth, ModelMap modelMap){
        Person person = new Person(name, dayOfBirth, monthOfBirth);
        personService.save(person);
        LOGGER.info(String.valueOf(person));
        modelMap.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/persons", modelMap);
    }

    @PostMapping("/persons/delete")
    @ResponseBody
    public ModelAndView delete(@RequestParam String name, ModelMap modelMap){
        personService.delete(name);
        LOGGER.info("Удален друг: " + name);
        modelMap.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/persons", modelMap);
    }

    @GetMapping("/persons")
    public String read(Model model){
        model.addAttribute("persons", personService.findAll());
        return "persons";
    }

}
