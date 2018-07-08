package ar.edu.utn.frba.dds.group5.students.viewmodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorViewModelTest {

    private ErrorViewModel viewModel;

    @Before
    public void loadTestDependencies() {
        viewModel = new ErrorViewModel("Error de prueba");
    }

    @Test
    public void testGetters() {
        assertEquals("Error de prueba", viewModel.getError());
    }
}
