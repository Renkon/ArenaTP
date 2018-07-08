package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentListViewModelTest {

    private StudentListViewModel viewModel;
    private Student student;

    @Before
    public void loadTestDependencies() {
        viewModel = new StudentListViewModel();
        student = new Student("","",0,"");
    }

    @Test
    public void testAddNewStudent() {
        assertEquals(0, viewModel.getStudents().size());
        viewModel.addStudent(student, "");
        assertEquals(1, viewModel.getStudents().size());
    }

    @Test
    public void testSetters() {
        List<Student> students = new ArrayList<>();
        students.add(student);
        assertEquals(0, viewModel.getStudents().size());
        viewModel.setStudents(students);
        assertEquals(1, viewModel.getStudents().size());
    }
}
