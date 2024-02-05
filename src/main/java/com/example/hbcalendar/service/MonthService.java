package com.example.hbcalendar.service;

import com.example.hbcalendar.model.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthService {

    @Autowired
    private MonthRepository monthRepository;

    public String getNameOfMonth(int id) {
        return monthRepository.findMonthById(id).getName();
    }
}
