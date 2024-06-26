package com.example.hbcalendar.service;

import com.example.hbcalendar.entities.User;
import com.example.hbcalendar.model.Person;
import com.example.hbcalendar.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findAllByUser(User user){
        return personRepository.findAllByUser(user);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void delete(String name) {
        List<Person> persons = personRepository.findAllByName(name);
        for (Person person: persons){
            personRepository.deleteById(person.getId());
        }
    }

    public Person findById(Long id){
        return personRepository.findById(id).orElse(null);
    }

}
