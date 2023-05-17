package com.jonahMusanyana.restweb.service;

import com.jonahMusanyana.restweb.model.Student;

import java.util.List;

public interface StudentService {
    public String createStudent(Student student);
    public String updateStudent(Student student);
    public String deleteStudent(String studentId);
    public Student getStudent(String studentId);
    public List<Student> getAllStudent();

}
