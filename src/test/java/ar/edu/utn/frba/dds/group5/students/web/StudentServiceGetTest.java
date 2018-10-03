package ar.edu.utn.frba.dds.group5.students.web;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import ar.edu.utn.frba.dds.group5.students.web.model.WebAssignment;
import ar.edu.utn.frba.dds.group5.students.web.model.WebStudent;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceGetTest {
    private Student student;
    private StudentService studentService;

    private final long DEFAULT_CODE = 111222333;

    @Before
    public void putStudent() {
        student = new Student("José", "Argento", 1234567, "pepe_argento");
        studentService = new StudentService();
        studentService.putStudent(student);
    }

    @Test
    public void testGetStudent() {
        WebStudent webStudent = studentService.getStudent();

        assertEquals(DEFAULT_CODE, webStudent.getCode());
        assertEquals(student.getFirstName(), webStudent.getFirstName());
        assertEquals(student.getLastName(), webStudent.getLastName());
        assertEquals(student.getGithubName(), webStudent.getGithubUser());
    }

    @Test
    public void testGetAssignments() {
        List<WebAssignment> assignments = studentService.getAssignmentHolder().getAssignments();
        for (int i = 0; i < 2; i++) {
            assertEquals(i + 1, assignments.get(i).getId());
            assertEquals("TPA" + (i + 1), assignments.get(i).getTitle());
            assertEquals("Entrega " + (i + 1) + " del TP Anual", assignments.get(i).getDescription());
        }
    }
}
