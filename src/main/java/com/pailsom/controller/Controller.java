package com.pailsom.controller;

import com.pailsom.annotation.LogTime;
import com.pailsom.model.Person;
import com.pailsom.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class Controller {

    private final PersonService service;

    @Autowired
    public Controller(PersonService service) {
        this.service = service;
    }

    @LogTime
    @GetMapping("/get")
    public List<Person> getValue() throws InterruptedException {
        return service.getPersons();
    }
}
