package ru.netology.hiberhw.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.netology.hiberhw.entity.Person;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class DBRepository {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getPersonByCity (String city) {
        List<Person> resultList = new ArrayList<>(personRepository.findByCityOfLiving(city));
        return resultList;
    }

    public List<Person> getPersonByAgeAndSort (int age) {
        List<Person> resultList = new ArrayList<>(personRepository.findByAgeLessThanEqualOrderByAge(age));
        return resultList;
    }

    public Person getPersonByNameAndSurname (String name, String surname) {
        List<Person> resultList = new ArrayList<>();
        Person person = personRepository.findByNameAndSurname(name, surname)
                .orElseThrow(() -> new EntityNotFoundException("пользователя с таким именем и фамилией н есуществует "
                        + name + " " + surname));
        return person;
    }



}
