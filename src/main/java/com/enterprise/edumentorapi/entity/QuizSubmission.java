package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "quiz_submission")
public class QuizSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "submission", cascade = CascadeType.ALL)
    private Set<Answer> answers;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

}