package com.enterprise.edumentorapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
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

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date cratedAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "enabled")
    private Boolean isEnabled;

    @OneToMany(mappedBy = "offeringCompany", cascade = CascadeType.ALL)
    @OrderBy("courseId ASC")
    private Set<Course> courses;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<CompanyStudent> companyStudents;

    @OneToOne
    @JoinColumn(name ="owner_id")
    private User owner;


}
