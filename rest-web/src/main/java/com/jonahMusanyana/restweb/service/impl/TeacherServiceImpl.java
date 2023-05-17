package com.jonahMusanyana.restweb.service.impl;

import com.jonahMusanyana.restweb.model.Teacher;
import com.jonahMusanyana.restweb.repository.TeacherRepository;
import com.jonahMusanyana.restweb.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository)
    {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public String createTeacher(Teacher teacher) {
        //logic
        teacherRepository.save(teacher);
        return "Success";
    }

    @Override
    public String updateTeacher(Teacher teacher) {
        //logic
        teacherRepository.save(teacher);
        return "Success";
    }

    @Override
    public String deleteTeacher(String teacherId) {
        //logic
        teacherRepository.deleteById(teacherId);
        return "Success";
    }

    @Override
    public Teacher getTeacher(String teacherId) {
        //logic
        return teacherRepository.findById(teacherId).get();
    }

    @Override
    public List<Teacher>getAllTeacher() {
        return teacherRepository.findAll();
    }
}

