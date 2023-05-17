package com.jonahMusanyana.restweb.controller;

import com.jonahMusanyana.restweb.model.Student;
import com.jonahMusanyana.restweb.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    //Read specified student details
    @GetMapping("{studentId}")
    public Student getStudentDetails(@PathVariable("studentId") String studentId)
    {
        return studentService.getStudent(studentId);
    }

    //Read all student details
    @GetMapping
    public List<Student> getAllStudentDetails()

    {
        return studentService.getAllStudent();
    }

    @PostMapping
    public String createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return "Student successfully created";
    }
    @PutMapping
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "Student successfully updated";
    }
    @DeleteMapping("{studentId}")
    public String deleteStudent(@PathVariable("studentId") String studentId){
        studentService.deleteStudent(studentId);
        return "Student successfully deleted";
    }
}
