package com.example.hbcalendar.model;

import com.example.hbcalendar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByName(String name);

    void deleteAllById(long id);

    List<Person> findAllByUser(User user);
}
