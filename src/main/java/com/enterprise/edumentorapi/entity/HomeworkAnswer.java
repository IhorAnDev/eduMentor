package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hw_answer")
public class HomeworkAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hw_answer_id")
    private Long homeworkAnswerId;

    @Column(name = "answer_url")
    private String answerUrl;

    @OneToOne(mappedBy = "homeworkAnswer")
    private HomeWorkSubmission homeWorkSubmission;
}
