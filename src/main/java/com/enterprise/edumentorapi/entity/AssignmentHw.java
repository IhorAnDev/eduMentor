package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"homeWork"})
@EqualsAndHashCode(exclude = {"homeWork"})
@Table(name = "assignment_hw")
public class AssignmentHw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id", nullable = false)
    private Long assignmentId;

    @Column(name = "assignment_task")
    private String assignmentTask;

    @OneToOne(mappedBy = "assignmentHw", cascade = CascadeType.ALL)
    private HomeWork homeWork;


}
