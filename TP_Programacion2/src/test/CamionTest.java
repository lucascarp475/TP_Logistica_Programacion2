package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import modelo.Camion;
import modelo.Paquete;

public class CamionTest {

    @Test
    public void testLIFO() {
        Camion c = new Camion();

        Paquete<String> p1 = new Paquete<>("1", 10, "A", "x", false);
        Paquete<String> p2 = new Paquete<>("2", 10, "A", "x", false);

        c.cargar(p1);
        c.cargar(p2);

        assertEquals("2", c.descargar().getId());
    }

    @Test
    public void testDeshacerCarga() {
        Camion c = new Camion();

        Paquete<String> p1 = new Paquete<>("1", 10, "A", "x", false);
        Paquete<String> p2 = new Paquete<>("2", 10, "A", "x", false);

        c.cargar(p1);
        c.cargar(p2);

        c.deshacerCarga();

        assertEquals("1", c.descargar().getId());
    }

    @Test
    public void testCamionVacio() {
        Camion c = new Camion();

        assertTrue(c.estaVacio());
    }
}