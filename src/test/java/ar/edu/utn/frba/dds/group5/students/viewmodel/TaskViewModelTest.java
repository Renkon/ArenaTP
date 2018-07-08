package ar.edu.utn.frba.dds.group5.students.viewmodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskViewModelTest {

    private TaskViewModel viewModel;

    @Before
    public void loadTestDependencies() {
        viewModel = new TaskViewModel();
    }

    @Test
    public void testGetters() {
        assertNotNull(viewModel.getTask());
        assertEquals("", viewModel.getAssignature());
        assertEquals("", viewModel.getDescription());
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
