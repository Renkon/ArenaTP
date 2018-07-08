package ar.edu.utn.frba.dds.group5.students.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NumericScoreTest {

    private NumericScore score;

    @Before
    public void loadTestDependencies() {
        score = new NumericScore(7);
    }

    @Test
    public void testGettersScore() {
        assertEquals(7, score.getScore());
    }

    @Test
    public void testScoreToString() {
        assertEquals("7", score.toString());
    }

    @Test
    public void testIsScorePassing() {
        assertTrue(score.isPassingScore());
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeScore() {
        new NumericScore(-1);
    }

    @Test(expected = RuntimeException.class)
    public void testHighScore() {
        new NumericScore(11);
    }
}
