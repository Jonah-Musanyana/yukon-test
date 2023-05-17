package com.jonahMusanyana.restweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class NavigationController {
    @GetMapping("/teachers")
    public String getTeachers() {
        return "teachers";
    }
    @GetMapping("/students")
    public String getStudents(){
            return "students";
    }
}
