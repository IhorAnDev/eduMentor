package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.ast.tree.update.Assignment;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "homework")
public class HomeWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hw_id", nullable = false)
    private Long homeWorkId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_mandatory")
    private Boolean isMandatory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="assignment_id")
    private AssignmentHw assignmentHw;

    @OneToOne(mappedBy = "homeWork")
    private Lesson lesson;
}
