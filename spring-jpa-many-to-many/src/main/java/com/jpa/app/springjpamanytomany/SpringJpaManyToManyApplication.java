package com.jpa.app.springjpamanytomany;

import com.jpa.app.springjpamanytomany.entity.Course;
import com.jpa.app.springjpamanytomany.entity.Student;
import com.jpa.app.springjpamanytomany.repository.CourseRepository;
import com.jpa.app.springjpamanytomany.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringJpaManyToManyApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringJpaManyToManyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaManyToManyApplication.class, args);
	}

	/**
	@Bean
	public CommandLineRunner demo(StudentRepository studentRepository, CourseRepository courseRepository){

		return args -> {

			Student student1 = new Student("Muhammad", "nirwansyah", "dicka", "dickanirwansyah@gmail.com");
			studentRepository.save(new Student("Ahmad", "yahya", "luthfi", "luthfiyahyaa@gmail.com"));
			studentRepository.save(new Student("Muhammad", "syahrozi", "ozi", "muhammadozi@yahoo.com"));
			studentRepository.save(new Student("Nurul", "Azka", "Azka", "Azka@gmail.com"));

			Course course1 = new Course("Programming Java");
			Course course2 = new Course("Spring boot basic");
			courseRepository.save(new Course("ReactJs & Redux"));
			courseRepository.save(new Course("AngularJs & Authentication"));

			courseRepository.save(course1);
			courseRepository.save(course2);

			Set<Course> courses = new HashSet<>();
			courses.add(course1);
			courses.add(course2);

			student1.setCourses(courses);
			studentRepository.save(student1);

		};
	}
	**/
}
