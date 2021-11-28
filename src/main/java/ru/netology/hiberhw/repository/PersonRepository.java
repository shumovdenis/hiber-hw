package ru.netology.hiberhw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hiberhw.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    List<Person> findByCityOfLiving(String cityOfLiving);
    List<Person> findByAgeLessThanEqualOrderByAge(int age);
    Optional<Person> findByNameAndSurname(String firstName, String surname);
}
