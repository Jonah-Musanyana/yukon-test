package com.jonahMusanyana.restweb.service;

import com.jonahMusanyana.restweb.model.Teacher;

import java.util.List;

    public interface TeacherService {
        public String createTeacher(Teacher teacher);
        public String updateTeacher(Teacher teacher);
        public String deleteTeacher(String teacherId);
        public Teacher getTeacher(String teacherId);
        public List<Teacher> getAllTeacher();

    }


