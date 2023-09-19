package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "offeringCompany", cascade = CascadeType.ALL)
    private Set<Course> courses;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<CompanyStudent> students;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User owner;


}
