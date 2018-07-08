package ar.edu.utn.frba.dds.group5.students.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AssignmentTest {

    private Assignment<ConceptualScore> conceptualAssignment;
    private Assignment<NumericScore> numericAssignment;
    private Task conceptualTask;
    private Task numericTask;

    @Before
    public void loadTestDependencies() {
        conceptualTask = new Task("Diseño de sistemas", "Trabajo práctico", true);
        numericTask = new Task("Diseño de sistemas", "Primer parcial", false);
        conceptualAssignment = new Assignment<>(conceptualTask);
        numericAssignment = new Assignment<>(numericTask);
    }

    @Test
    public void testGettersAssignment() {
        assertEquals(conceptualAssignment.getTask(), conceptualTask);
    }

    @Test
    public void testAddScore() {
        assertEquals(0, numericAssignment.getScores().size());
        numericAssignment.addScore(new NumericScore(7));
        assertEquals(1, numericAssignment.getScores().size());
    }

    @Test
    public void testIsPassedAssignmentWithNoScore() {
        assertEquals(false, numericAssignment.isPassedAssignment());
    }

    @Test
    public void testIsPassedAssignmentWithScore() {
        conceptualAssignment.addScore(new ConceptualScore('B', Optional.of('-')));
        assertEquals(true, conceptualAssignment.isPassedAssignment());
    }

    @Test
    public void testGetScoresAsString() {
        numericAssignment.addScore(new NumericScore(5));
        numericAssignment.addScore(new NumericScore(10));
        assertEquals("5, 10", numericAssignment.getScoresAsString());
    }

    @Test
    public void testGetPositiveStatus() {
        conceptualAssignment.addScore(new ConceptualScore('M', null));
        assertEquals("No aprobado", conceptualAssignment.getStatus());
    }

    @Test
    public void testGetNegativeStatus() {
        conceptualAssignment.addScore(new ConceptualScore('R', null));
        assertEquals("Aprobado", conceptualAssignment.getStatus());
    }

    @Test
    public void testSettersAssignment() {
        Task tempTask = new Task("Diseño de sistemas",
                "Tarea para el hogar", true);
        conceptualAssignment.setTask(tempTask);
        assertEquals(tempTask, conceptualAssignment.getTask());
    }

    @Test
    public void testScores() {
        assertEquals(0, numericAssignment.getScores().size());
        List<NumericScore> scores = Arrays.asList(
                new NumericScore(2), new NumericScore(4), new NumericScore(6)
        );
        numericAssignment.setScores(scores);
        assertEquals(3, numericAssignment.getScores().size());
    }

    @Test
    public void testToString() {
        assertEquals(conceptualTask.toString(), conceptualAssignment.toString());
    }
}
