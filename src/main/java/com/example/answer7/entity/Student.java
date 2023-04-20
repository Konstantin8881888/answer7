package com.example.answer7.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;
}
