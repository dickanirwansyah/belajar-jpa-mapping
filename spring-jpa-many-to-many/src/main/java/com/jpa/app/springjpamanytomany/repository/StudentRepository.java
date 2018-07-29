package com.jpa.app.springjpamanytomany.repository;

import com.jpa.app.springjpamanytomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
