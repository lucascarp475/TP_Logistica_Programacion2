package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import modelo.Paquete;

public class PaqueteTest {

    @Test
    public void testEsPrioritarioPorUrgente() {
        Paquete<String> p = new Paquete<>("1", 10, "A", "x", true);
        assertTrue(p.esPrioritario());
    }

    @Test
    public void testEsPrioritarioPorPeso() {
        Paquete<String> p = new Paquete<>("2", 60, "A", "x", false);
        assertTrue(p.esPrioritario());
    }

    @Test
    public void testNoEsPrioritario() {
        Paquete<String> p = new Paquete<>("3", 20, "A", "x", false);
        assertFalse(p.esPrioritario());
    }
}