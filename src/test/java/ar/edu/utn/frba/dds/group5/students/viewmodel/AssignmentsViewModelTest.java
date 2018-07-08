package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.*;
import ar.edu.utn.frba.dds.group5.students.utils.HashingUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssignmentsViewModelTest {

    private Student student;
    private Assignment<Score> assignment;
    private Task task;
    private AssignmentsViewModel viewModel;

    @Before
    public void loadTestDependencies() {
        student = new Student("Cosme", "Fulanito",
                15859, "cfulanito", HashingUtils.sha256Of("123"));
        task = new Task("Diseño de sistemas", "TP", true);
        assignment = new Assignment(task);
        viewModel = new AssignmentsViewModel(student);
    }

    @Test
    public void testGetters() {
        assertEquals(student, viewModel.getStudent());
        assertNull(viewModel.getAssignment());
    }

    @Test
    public void testSetters() {
        viewModel.setAssignment(assignment);
        assertEquals(assignment, viewModel.getAssignment());
    }

    @Test
    public void testGetScoreCreatable() {
        assertFalse(viewModel.getScoreCreatable());
        viewModel.setAssignment(assignment);
        assertTrue(viewModel.getScoreCreatable());
    }

    @Test
    public void testCreateNewAssignment() {
        assertEquals(0, student.getAssignments().size());
        viewModel.createAssignment(task);
        assertEquals(1, student.getAssignments().size());
    }

    @Test
    public void testAddNewScore() {
        assertEquals(0, assignment.getScores().size());
        viewModel.setAssignment(assignment);
        viewModel.addScore(new NumericScore(6));
        assertEquals(1, assignment.getScores().size());
    }

    @Test
    public void testIsAssignmentScoreConceptual() {
        viewModel.setAssignment(assignment);
        assertTrue(viewModel.isAssignmentScoreConceptual());
    }
}
