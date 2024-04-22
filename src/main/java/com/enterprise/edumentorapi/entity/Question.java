package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<AnswerOption> answerOptions;
}
