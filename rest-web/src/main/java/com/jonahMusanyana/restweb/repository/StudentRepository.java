package com.jonahMusanyana.restweb.repository;

import com.jonahMusanyana.restweb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, String>{
    List<Student> findByName(String name);

}
