package com.jonahMusanyana.restweb.service.impl;

import com.jonahMusanyana.restweb.exception.StudentNotFoundException;
import com.jonahMusanyana.restweb.model.Student;
import com.jonahMusanyana.restweb.repository.StudentRepository;
import com.jonahMusanyana.restweb.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @Override
    public String createStudent(Student student) {
        //logic
        studentRepository.save(student);
        return "Success";
    }

    @Override
    public String updateStudent(Student student) {
        //logic
        studentRepository.save(student);
        return "Success";
    }

    @Override
    public String deleteStudent(String studentId) {
        //logic
        studentRepository.deleteById(studentId);
        return "Success";
    }

    @Override
    public Student getStudent(String studentId) {
        //logic
        if (studentRepository.findById(studentId).isEmpty())
            throw new StudentNotFoundException("Requested student does not exist");
        return studentRepository.findById(studentId).get();
    }

    @Override
    public List<Student> getAllStudent() {
        //logic
        return studentRepository.findAll();
    }
}
