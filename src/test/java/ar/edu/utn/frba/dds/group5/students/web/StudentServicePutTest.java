package ar.edu.utn.frba.dds.group5.students.web;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import ar.edu.utn.frba.dds.group5.students.web.model.WebStudent;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentServicePutTest {
    @Test
    public void testPutStudent() {
        Student student = new Student("Randall", "López", 999999, "rlopez");
        StudentService studentService = new StudentService();
        WebStudent webStudent = studentService.putStudent(student);

        assertEquals(student.getFileId(), webStudent.getCode());
        assertEquals(student.getFirstName(), webStudent.getFirstName());
        assertEquals(student.getLastName(), webStudent.getLastName());
        assertEquals(student.getGithubName(), webStudent.getGithubUser());
    }
}
