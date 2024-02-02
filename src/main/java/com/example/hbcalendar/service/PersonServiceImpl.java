package com.example.hbcalendar.service;

import com.example.hbcalendar.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Map<Integer, Person> PERSONS = new HashMap<>();

    private static final AtomicInteger PERSON_ID_COUNTER = new AtomicInteger();

    @Override
    public void create(Person person) {
        final int PERSON_ID = PERSON_ID_COUNTER.incrementAndGet();
        PERSONS.put(PERSON_ID, person);
    }

    @Override
    public Person read(int id ) {
        return PERSONS.get(id);
    }
}
