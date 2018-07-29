package com.jpa.app.springjpamanytomany.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "course")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcourse;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
}
