package ru.netology.hiberhw.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person implements Serializable {
    @Id
    @Column(nullable = false)
    String name;
    @Id
    @Column(nullable = false)
    String surname;
    @Id
    @Column(nullable = false)
    int age;

    String phoneNumber;
    String cityOfLiving;
}
