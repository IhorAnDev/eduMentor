package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Answer that = (Answer) obj;
        return Objects.equals(question.getQuestionId(), that.question.getQuestionId()) &&
                Objects.equals(chosenOption.getOptionId(), that.chosenOption.getOptionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(question.getQuestionId(), chosenOption.getOptionId());
    }


}