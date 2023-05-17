package com.jonahMusanyana.restweb.service.impl;

import com.jonahMusanyana.restweb.model.Student;
import com.jonahMusanyana.restweb.repository.StudentRepository;
import com.jonahMusanyana.restweb.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    private StudentService studentService;
    //close all unneeded resources on class execution finish
    AutoCloseable autoCloseable;
    Student student;


    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        studentService= new StudentServiceImpl(studentRepository);
        student= new Student("1","jane","Moore");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateStudent() {
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.save(student)).thenReturn(student);
        assertThat(studentService.createStudent(student)).isEqualTo("Success");

    }

    @Test
    void testUpdateStudent() {
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.save(student)).thenReturn(student);
        assertThat(studentService.updateStudent(student)).isEqualTo("Success");
    }

    @Test
    void testGetStudent() {
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.findById("1")).thenReturn(Optional.ofNullable(student));
        assertThat(studentService.getStudent("1")
                .getName()).isEqualTo(student.getName());
    }


    @Test
    void testGetAllStudent() {
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.findAll()).thenReturn(
                new ArrayList<Student>(Collections.singleton(student))
        );
        assertThat(studentService.getAllStudent().get(0).getName())
                .isEqualTo(student.getName());
    }


    @Test
    void testDeleteStudent() {
        mock(Student.class);
        mock(StudentRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(
                studentRepository).deleteById(any());

        assertThat(studentService.deleteStudent("1")).isEqualTo("Success");

    }
}