package ar.edu.utn.frba.dds.group5.students.model;

import static org.junit.Assert.*;

import ar.edu.utn.frba.dds.group5.students.utils.HashingUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {

    private Student student;
    private Task taskDds1;
    private Task taskDds2;

    @Before
    public void loadTestDependencies() {
        student = new Student("Juan","Lopez",1524763,"JuanLopezUTN", HashingUtils.sha256Of("1234"));
        taskDds1 = new Task("Diseño de Sistemas","Trabajo práctico", true);
        taskDds2 = new Task("Diseño de Sistemas", "Primer parcial", false);
    }

    @Test
    public void testGettersStudent() {
        assertEquals("Juan", student.getFirstName());
        assertEquals("Lopez", student.getLastName());
        assertEquals(1524763, student.getFileId());
        assertEquals("JuanLopezUTN", student.getGithubName());
        assertEquals(HashingUtils.sha256Of("1234"), student.getHashedPassword());
    }

    @Test
    public void testAddNewAssignment() {
        assertEquals(0, student.getAssignments().size());
        student.addNewAssignment(taskDds1);
        student.addNewAssignment(taskDds2);
        assertEquals(2, student.getAssignments().size());
    }

    @Test
    public void testGetCompleteUniversityName() {
        assertEquals("1524763 - Juan Lopez", student.getCompleteUniversityName());
    }

    @Test
    public void testNewDummyStudent() {
        Student dummyStudent = Student.getDummyStudent();
        assertEquals("", dummyStudent.getFirstName());
        assertEquals("", dummyStudent.getLastName());
        assertEquals(0, dummyStudent.getFileId());
        assertEquals("", dummyStudent.getGithubName());
        assertEquals("", dummyStudent.getHashedPassword());
    }

    @Test
    public void testSettersStudent() {
        student.setFirstName("Cosme");
        student.setLastName("Fulanito");
        student.setFileId(1234);
        student.setGithubName("cfulano");
        student.setHashedPassword(HashingUtils.sha256Of("123"));
        student.setAssignments(new ArrayList<>());
        assertEquals("Cosme", student.getFirstName());
        assertEquals("Fulanito", student.getLastName());
        assertEquals(1234, student.getFileId());
        assertEquals("cfulano", student.getGithubName());
        assertEquals(HashingUtils.sha256Of("123"), student.getHashedPassword());
        assertEquals(0, student.getAssignments().size());
    }

}
