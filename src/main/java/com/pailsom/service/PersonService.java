package com.pailsom.service;

import com.pailsom.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PersonService {

    public List<Person> getPersons() throws InterruptedException {
        Thread.sleep(3000);
        return getList();
    }

    private List<Person> getList(){
        return IntStream.range(0,10).mapToObj(i->
            Person.builder().firstName("Name"+i).lastName("LastName"+i).salary((long)i).address("address"+i).build()
        ).collect(Collectors.toList());
    }
}
