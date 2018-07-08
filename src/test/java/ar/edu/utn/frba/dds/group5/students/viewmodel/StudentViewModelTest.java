package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import ar.edu.utn.frba.dds.group5.students.utils.HashingUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentViewModelTest {

    private StudentViewModel viewModel;
    private Student student;

    @Before
    public void loadTestDependencies() {
        viewModel = new StudentViewModel();
        student = new Student("Ash", "Ketchup", 12345,
                "pikachu", HashingUtils.sha256Of("char* mander"));
        viewModel.setStudent(student);
    }

    @Test
    public void testGetters() {
        assertNotNull(viewModel.getStudent());
        assertTrue(viewModel.isSelected());
        assertEquals("Ash", viewModel.getFirstName());
        assertEquals("Ketchup", viewModel.getLastName());
        assertEquals(12345, viewModel.getFileId());
        assertEquals("pikachu", viewModel.getGithubName());
        assertEquals(HashingUtils.sha256Of("char* mander"), viewModel.getHashedPassword());
    }

    @Test
    public void testSetters() {
        viewModel.setFirstName("Apu");
        viewModel.setLastName("Nahasapeemapetilon");
        viewModel.setFileId(4095);
        viewModel.setGithubName("kwik-e-mart-github");
        assertEquals("Apu", viewModel.getFirstName());
        assertEquals("Nahasapeemapetilon", viewModel.getLastName());
        assertEquals(4095, viewModel.getFileId());
        assertEquals("kwik-e-mart-github", viewModel.getGithubName());
    }

    @Test
    public void testIsPasswordMatching() {
        assertTrue(viewModel.isPasswordMatching(HashingUtils.sha256Of("char* mander")));
        assertFalse(viewModel.isPasswordMatching(HashingUtils.sha256Of("THE GAME")));
    }
}
