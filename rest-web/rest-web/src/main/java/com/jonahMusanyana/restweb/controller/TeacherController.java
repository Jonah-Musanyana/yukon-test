package com.jonahMusanyana.restweb.controller;

import com.jonahMusanyana.restweb.model.Teacher;
import com.jonahMusanyana.restweb.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teacher")
public class TeacherController {
    TeacherService teacherService;

    public TeacherController(TeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    //Read specified teacher details
    @GetMapping("{teacherId}")
    public Teacher getTeacherDetails(@PathVariable("teacherId") String teacherId)
    {
        return teacherService.getTeacher(teacherId);
    }

    //Read all teacher details
    @GetMapping
    public List<Teacher> getAllTeacherDetails()
    {
        System.out.println("get all teachers invoked.... ");

        return teacherService.getAllTeacher();
    }

    @PostMapping
    public String createTeacher(@RequestBody Teacher teacher)
    {
        System.out.println(teacher.getName());
        teacherService.createTeacher(teacher);
        return "Teacher successfully created";
    }
    @PutMapping
    public String updateTeacher(@RequestBody Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "Student successfully updated";
    }
    @DeleteMapping("{teacherId}")
    public String deleteTeacher(@PathVariable("teacherId") String teacherId){
        teacherService.deleteTeacher(teacherId);
        return "Teacher successfully deleted";
    }
}
