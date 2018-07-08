package ar.edu.utn.frba.dds.group5.students.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    private Student student = new Student("Juan","Lopez",1524763,"JuanLopezUTN","1234");
    private Task taskDisenio = new Task("Disenio de Sistema","Materia de tercer anio");

    @Before
    public void loadTestDependencies(){
        student.addNewAssignment(taskDisenio);
    }

    @Test
    public void testCreateStudent(){
        assertEquals("Juan",student.getFirstName());
        assertEquals("Lopez",student.getLastName());
        assertEquals(1524763,student.getFileId());
        assertEquals("JuanLopezUTN",student.getGithubName());
        assertEquals("1234",student.getHashedPassword());
    }

    @Test
    public void testAddNewAssignment(){
        assertEquals(1,student.getAssignments().size());
    }

}
