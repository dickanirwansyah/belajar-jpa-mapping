package com.jpa.app.springjpamanytomany.repository;


import com.jpa.app.springjpamanytomany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>{

    List<Course> findByName(String name);

    Course findByIdcourse(Long idcourse);
}
