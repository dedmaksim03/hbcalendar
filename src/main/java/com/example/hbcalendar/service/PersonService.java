package com.example.hbcalendar.service;

import com.example.hbcalendar.model.Person;

public interface PersonService {

    void create(Person person);

    Person read(int id);
}
