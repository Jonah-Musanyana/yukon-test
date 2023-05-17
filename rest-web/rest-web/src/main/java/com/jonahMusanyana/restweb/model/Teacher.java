package com.jonahMusanyana.restweb.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="teacher_info")
public class Teacher {

    @Id
    private String teacherId;
    private String name;

    @OneToMany(mappedBy = "teacher")
    private Set<Student> Students;

    public Teacher() {
    }

    public Teacher(String teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
