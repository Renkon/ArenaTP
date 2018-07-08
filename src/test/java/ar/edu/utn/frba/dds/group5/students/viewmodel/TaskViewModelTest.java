package ar.edu.utn.frba.dds.group5.students.viewmodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TaskViewModelTest {

    private TaskViewModel viewModel;

    @Before
    public void loadTestDependencies() {
        viewModel = new TaskViewModel();
    }

    @Test
    public void testGetters() {
        assertEquals("", viewModel.getTask().getAssignature());
        assertEquals("", viewModel.getAssignature());
        assertEquals("", viewModel.getTask().getDescription());
        assertEquals("", viewModel.getDescription());
        assertFalse(viewModel.getTask().isConceptual());
        assertFalse(viewModel.isConceptual());
    }

    @Test
    public void testSetters() {
        viewModel.setAssignature("Diseño de sistemas");
        viewModel.setDescription("TP");
        viewModel.setConceptual(true);
        assertEquals("Diseño de sistemas", viewModel.getAssignature());
        assertEquals("TP", viewModel.getDescription());
        assertTrue(viewModel.isConceptual());
    }


}
