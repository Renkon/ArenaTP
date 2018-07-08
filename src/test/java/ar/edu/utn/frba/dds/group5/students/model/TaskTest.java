package ar.edu.utn.frba.dds.group5.students.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TaskTest {
    private Task task;

    @Before
    public void loadTestDependencies() {
        task = new Task("Diseño de sistemas", "Tarea", true);
    }

    @Test
    public void testGetters() {
        assertEquals("Diseño de sistemas", task.getAssignature());
        assertEquals("Tarea", task.getDescription());
        assertTrue(task.isConceptual());
    }

    @Test
    public void testSetters() {
        task.setAssignature("Gestión de datos");
        task.setDescription("TP cuatrimestral");
        task.setConceptual(false);
        assertEquals("Gestión de datos", task.getAssignature());
        assertEquals("TP cuatrimestral", task.getDescription());
        assertFalse(task.isConceptual());
    }

    @Test
    public void testToString() {
        assertEquals("Diseño de sistemas - Tarea", task.toString());
    }
}
