package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"user", "quiz", "answers"})
@Table(name = "quiz_submission")
public class QuizSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @ToString.Exclude
    private Quiz quiz;

    @OneToMany(mappedBy = "submission", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Answer> answers;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

}