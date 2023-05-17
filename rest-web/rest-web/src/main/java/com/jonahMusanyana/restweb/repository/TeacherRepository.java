package com.jonahMusanyana.restweb.repository;

import com.jonahMusanyana.restweb.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

}
