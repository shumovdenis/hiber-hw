package ru.netology.hiberhw.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hiberhw.entity.Person;
import ru.netology.hiberhw.repository.DBRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class Controller {
    final DBRepository dbRepository;

    public Controller(DBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @GetMapping("/persons/by-city")
    @Secured("ROLE_WRITE")
    public List<Person> getCity(@RequestParam("city") String city) {
        return dbRepository.getPersonByCity(city);
    }

    @GetMapping("/persons/by-age")
    @RolesAllowed("ROLE_READ")
    public List<Person> getCity(@RequestParam("age") int age) {
        return dbRepository.getPersonByAgeAndSort(age);
    }

    @GetMapping("/persons/by-name")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Person getCity(@RequestParam("name") String name,@RequestParam("surname") String surname) {
        return dbRepository.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/hello")
    @PreAuthorize("#username == authentication.principal.username")
    public String greetings(@RequestParam("username") String username) {
        return "Hello " + username;
    }



}
