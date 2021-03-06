package ru.netology.hiberhw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hiberhw.entity.Person;
import ru.netology.hiberhw.repository.DBRepository;

import java.util.List;

@RestController
public class Controller {
    final DBRepository dbRepository;


    public Controller(DBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getCity(@RequestParam("city") String city) {
        return dbRepository.getPersonByCity(city);
    }
}
