package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.HashCodeExclude;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"questions"})
@ToString(exclude = {"questions"})
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id", nullable = false)
    private Long quizId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    @OrderBy("questionId ASC")
    private Set<Question> questions;
}

