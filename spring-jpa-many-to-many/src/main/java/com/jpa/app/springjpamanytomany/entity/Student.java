package com.jpa.app.springjpamanytomany.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

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

    public Student(){}

    public long getIdstudent(){
        return idstudent;
    }

    public void setIdstudent(long idstudent){
        this.idstudent = idstudent;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Set<Course> getCourses(){
        return courses;
    }

    public void setCourses(Set<Course> courses){
        this.courses = courses;
    }
}
