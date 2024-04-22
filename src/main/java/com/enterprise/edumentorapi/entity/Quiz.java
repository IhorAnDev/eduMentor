package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id", nullable = false)
    private Long quizId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private Set<Question> questions;
}

