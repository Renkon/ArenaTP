package ar.edu.utn.frba.dds.group5.students.viewmodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordViewModelTest {

    private PasswordViewModel viewModel;

    @Before
    public void loadTestDependencies() {
        viewModel = new PasswordViewModel();
    }

    @Test
    public void testGetters() {
        assertEquals("", viewModel.getPassword());
        assertEquals("47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU=", viewModel.getHashedPassword());
    }

    @Test
    public void testSetters() {
        viewModel.setPassword("pepe");
        assertEquals("pepe", viewModel.getPassword());
        assertEquals("fJ58FJSyaEq3wZ1q/3N+Rg+p6Y1aI02hMQyX3fVpGDQ=", viewModel.getHashedPassword());
    }
}
