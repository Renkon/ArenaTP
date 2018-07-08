package ar.edu.utn.frba.dds.group5.students.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashingUtilsTest {

    @Test
    public void testSha256Of() {
        assertEquals("fJ58FJSyaEq3wZ1q/3N+Rg+p6Y1aI02hMQyX3fVpGDQ=",
                HashingUtils.sha256Of("pepe"));
    }
}
