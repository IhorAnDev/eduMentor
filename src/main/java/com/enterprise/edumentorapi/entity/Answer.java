package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "chosen_option_id")
    private AnswerOption chosenOption;

    @ManyToOne
    @JoinColumn(name = "submission_id")
    private QuizSubmission submission;
}