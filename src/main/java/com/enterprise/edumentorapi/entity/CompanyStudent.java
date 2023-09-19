package com.enterprise.edumentorapi.entity;

import com.enterprise.edumentorapi.enums.CompanyRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_student")
public class CompanyStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private CompanyRole role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
