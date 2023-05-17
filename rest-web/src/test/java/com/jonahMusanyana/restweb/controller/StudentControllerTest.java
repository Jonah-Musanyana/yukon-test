package com.jonahMusanyana.restweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jonahMusanyana.restweb.model.Student;
import com.jonahMusanyana.restweb.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;
    Student studentOne;
    Student studentTwo;

    List<Student> studentList=new ArrayList<>();

    @BeforeEach
    void setUp() {
        studentOne=new Student("1","joe","Goodman");
        studentTwo= new Student("2","Kate","Wun");
        studentList.add(studentOne);
        studentList.add(studentTwo);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetStudentDetails() throws Exception{

        when(studentService.getStudent("1"))
                .thenReturn(studentOne);
        this.mockMvc.perform(get("/student/1"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testGetAllStudentDetails() throws Exception{

        when(studentService.getAllStudent())
                .thenReturn(studentList);
        this.mockMvc.perform(get("/student"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreateStudent() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(studentOne);

        when(studentService.createStudent(studentOne))
                .thenReturn("Success");
        this.mockMvc.perform(post("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateStudent() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(studentOne);

        when(studentService.updateStudent(studentOne))
                .thenReturn("Success");
        this.mockMvc.perform(put("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeleteStudent() throws Exception{
        when(studentService.deleteStudent("1"))
                .thenReturn("Success");
        this.mockMvc.perform(delete("/student/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}