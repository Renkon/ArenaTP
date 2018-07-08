package ar.edu.utn.frba.dds.group5.students.model;

import ar.edu.utn.frba.dds.group5.students.model.ConceptualScore;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConceptualScoreTest {

    private ConceptualScore score;

    @Before
    public void loadTestDependencies() {
        score = new ConceptualScore('B', Optional.of('+'));
    }

    @Test
    public void testScoreToString() {
        assertEquals("B+", score.toString());
    }

    @Test
    public void testIsPassingScore() {
        assertTrue(score.isPassingScore());
    }
}
