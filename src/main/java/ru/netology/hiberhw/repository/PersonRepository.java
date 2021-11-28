package ru.netology.hiberhw.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hiberhw.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findCity(@Param("city") String cityOfLiving);

    @Query("select p from Person p where p.age < :age")
    List<Person> findAge(@Param("age") int age, Sort sort);

    @Query("select p from Person p where p.name = :name and p.surname = :surname")
    Optional<Person> findNameSurname(@Param("name") String name, @Param("surname") String surname);


}
