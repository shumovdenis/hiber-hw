package ru.netology.hiberhw.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FIO.class)
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
