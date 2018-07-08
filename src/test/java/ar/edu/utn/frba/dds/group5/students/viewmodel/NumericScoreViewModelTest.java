package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.NumericScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumericScoreViewModelTest {

    private NumericScoreViewModel viewModel;

    @Before
    public void loadTestDependencies() {
        viewModel = new NumericScoreViewModel();
        viewModel.setValue(8);
    }

    @Test
    public void testGetters() {
        assertEquals(new Integer(8), viewModel.getValue());
    }

    @Test
    public void testGetScore() {
        assertEquals(8, ((NumericScore)viewModel.getScore()).getScore());
    }

    @Test
    public void testIsInputValid() {
        assertTrue(viewModel.getInputValid());
        viewModel.setValue(null);
        assertFalse(viewModel.getInputValid());
    }
}
