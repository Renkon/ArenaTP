package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.ConceptualScore;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


public class ConceptualScoreViewModelTest {

    private ConceptualScoreViewModel viewModel;
    private ConceptualScore score;

    @Before
    public void loadTestDependencies() {
        viewModel = new ConceptualScoreViewModel();
        score = new ConceptualScore('R', Optional.empty());
        viewModel.setValue(score.getLetter());
        viewModel.setModifier(score.getModifier().orElse( null));
    }

    @Test
    public void testGetters() {
        assertEquals(new Character('R'), viewModel.getValue());
        assertNull(viewModel.getModifier());
    }

    @Test
    public void testConstantGetters() {
        List<Character> conceptuals = Arrays.asList('M', 'R', 'B');
        List<Character> modifiers = Arrays.asList('+', '-');
        // Verifico que sean los mismos elementos exactamente
        assertTrue(conceptuals.containsAll(viewModel.getConceptualValues()) &&
                viewModel.getConceptualValues().containsAll(conceptuals));
        assertTrue(modifiers.containsAll(viewModel.getModifiers()) &&
                viewModel.getModifiers().containsAll(modifiers));
    }

    @Test
    public void testGetScore() {
        assertEquals(score.getLetter(), ((ConceptualScore) viewModel.getScore()).getLetter());
        assertEquals(score.getModifier(), ((ConceptualScore) viewModel.getScore()).getModifier());
    }

    @Test
    public void testGetInputValid() {
        assertTrue(viewModel.getInputValid());
        viewModel.setValue(null);
        assertFalse(viewModel.getInputValid());
    }
}
