package ru.netology.hiberhw.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.netology.hiberhw.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DBRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonByCity (String city) {
        Query query = entityManager.createQuery(read("myScript.sql"), Person.class);
        query.setParameter("city", city);
        List<Person> resultList = query.getResultList();
        return resultList;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
