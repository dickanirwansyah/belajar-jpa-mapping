package com.jpa.app.springjpamanytomany.repository;

import com.jpa.app.springjpamanytomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{

    List<Student> findByLastname(String lastname);

    Student findByIdstudent(Long idstudent);
}
