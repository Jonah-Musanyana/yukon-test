package com.jonahMusanyana.restweb.repository;

import com.jonahMusanyana.restweb.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StudentRepositoryTest {
// given- when - then

    @Autowired
    private StudentRepository studentRepository;
    Student student;

    @BeforeEach
    void setUp() {
        student= new Student("1","jane","Moore");
        studentRepository.save(student);

    }

    @AfterEach
    void tearDown() {
        student=null;
        studentRepository.deleteAll();
    }
    //Test case Success

    @Test
    void testFindByName_Found()
    {
       List<Student> studentList= studentRepository.findByName("jane");
       assertThat(studentList.get(0).getStudentId()).isEqualTo(student.getStudentId());
       assertThat(studentList.get(0).getSurname()).isEqualTo(student.getSurname());
    }

    //Test case FAILURE
    @Test
    void testFindByName_NotFound()
    {
        List<Student> studentList= studentRepository.findByName("james");
        assertThat(studentList.isEmpty()).isTrue();
    }
}
