package com.jonahMusanyana.restweb.repository;

import com.jonahMusanyana.restweb.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateNewTeacher() {

        Teacher savedTeacher = teacherRepository.save(new Teacher("1","jane"));

        assertNotNull (savedTeacher);
        assertTrue(savedTeacher.getTeacherId().length()>0);

    }
    @Test
    public void testList(){

        entityManager.persist(new Teacher("12","John"));
        entityManager.persist(new Teacher("T1","James"));
        entityManager.persist(new Teacher("3","Joe"));

        List<Teacher> listTeachers=(List<Teacher>) teacherRepository.findAll();

        for(Teacher teacher : listTeachers){
            System.out.println(teacher.getName());
        }
        assertThat(listTeachers).isNotEmpty();
    }
}
