package com.jonahMusanyana.restweb.model;

import jakarta.persistence.*;

@Entity
@Table(name="student_info")
public class Student {

    @Id
    private String studentId;
    private String name;
    private String surname;
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Student() {
    }

    public Student(String studentId, String name, String surname) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
