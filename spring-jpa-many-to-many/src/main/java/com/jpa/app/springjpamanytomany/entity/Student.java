package com.jpa.app.springjpamanytomany.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "student")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idstudent;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "student_course",
        joinColumns = {
            @JoinColumn(name = "idstudent")
        },
    inverseJoinColumns = {
            @JoinColumn(name = "idcourse")
    })
    private Set<Course> courses = new HashSet<>();

    public Student(){

    }

    public Student(String firstname, String lastname, String nickname, String email){
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
    }
}
