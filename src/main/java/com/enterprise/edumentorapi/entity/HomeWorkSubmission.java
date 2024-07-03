package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "homeWork"})
@EqualsAndHashCode(exclude = {"user", "homeWork", "homeworkAnswer"})
@Table(name = "hw_submission")
public class HomeWorkSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submissionId;

    @Column(name = "grade")
    private int grade;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hw_id")
    private HomeWork homeWork;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hw_answer_id")
    private HomeworkAnswer homeworkAnswer;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

}
