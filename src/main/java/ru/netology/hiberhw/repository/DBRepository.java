package ru.netology.hiberhw.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.netology.hiberhw.entity.Person;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class DBRepository {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getPersonByCity (String city) {
        List<Person> resultList = new ArrayList<>(personRepository.findCity(city));
        return resultList;
    }

    public List<Person> getPersonByAgeAndSort (int age) {
        List<Person> resultList = new ArrayList<>(personRepository.findAge(age, Sort.by("age")));
        return resultList;
    }

    public Person getPersonByNameAndSurname (String name, String surname) {
        List<Person> resultList = new ArrayList<>();
        Person person = personRepository.findNameSurname(name, surname)
                .orElseThrow(() -> new EntityNotFoundException("пользователя с таким именем и фамилией н есуществует "
                        + name + " " + surname));
        return person;
    }



}
