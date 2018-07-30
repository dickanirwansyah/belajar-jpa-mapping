package com.jpa.app.springjpamanytomany.controller;

import com.jpa.app.springjpamanytomany.entity.Course;
import com.jpa.app.springjpamanytomany.entity.Student;
import com.jpa.app.springjpamanytomany.repository.CourseRepository;
import com.jpa.app.springjpamanytomany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerStudent {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String index(Model model){
        List<Student> students = studentRepository.findAll();
        model.addAttribute("title", "Data Student");
        model.addAttribute("data", students);
        return "students";
    }

    //new student
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    //save student
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String newStudent(Student student){
        studentRepository.save(student);
        return "redirect:/students";
    }

    //delete student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable("id") Long id){
        Student student = studentRepository.findByIdstudent(id);
        if (student!=null){
            studentRepository.delete(student);
        }
        return "redirect:/students";
    }

    //add course student
    @RequestMapping(value = "/addStudentCourse/{id}", method = RequestMethod.GET)
    public String addStudentCourse(@PathVariable("id") Long studentId, Model model){
        model.addAttribute("title", "Add Course Student");
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("student", studentRepository.findByIdstudent(studentId));
        return "addStudentCourse";
    }

    //execute add course into student
    @RequestMapping(value = "/student/{id}/courses", method = RequestMethod.GET)
    public String addCourseStudent(@PathVariable("id") Long id,
                                   @RequestParam Long courseId,
                                   Model model){

        Student student = studentRepository.findByIdstudent(id);
        Course course = courseRepository.findByIdcourse(courseId);
        if (student!=null){
            if (!student.isCourse(course)){
                student.getCourses().add(course);
            }
            studentRepository.save(student);
            model.addAttribute("student", studentRepository.findByIdstudent(id));
            model.addAttribute("courses", courseRepository.findAll());
            return "redirect:/students";
        }
        return "redirect:/students";
    }

}
