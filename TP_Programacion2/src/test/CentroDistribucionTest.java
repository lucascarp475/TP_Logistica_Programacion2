package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import modelo.CentroDistribucion;
import modelo.Paquete;

public class CentroDistribucionTest {

    @Test
    public void testPrioridadUrgente() {
        CentroDistribucion c = new CentroDistribucion();

        Paquete<String> normal = new Paquete<>("1", 10, "A", "x", false);
        Paquete<String> urgente = new Paquete<>("2", 10, "A", "x", true);

        c.agregarPaquete(normal);
        c.agregarPaquete(urgente);

        assertEquals("2", c.procesar().getId());
    }

    @Test
    public void testPrioridadPorPeso() {
        CentroDistribucion c = new CentroDistribucion();

        Paquete<String> normal = new Paquete<>("1", 10, "A", "x", false);
        Paquete<String> pesado = new Paquete<>("2", 60, "A", "x", false);

        c.agregarPaquete(normal);
        c.agregarPaquete(pesado);

        assertEquals("2", c.procesar().getId());
    }

    @Test
    public void testOrdenNormal() {
        CentroDistribucion c = new CentroDistribucion();

        Paquete<String> p1 = new Paquete<>("1", 10, "A", "x", false);
        Paquete<String> p2 = new Paquete<>("2", 20, "A", "x", false);

        c.agregarPaquete(p1);
        c.agregarPaquete(p2);

        assertEquals("1", c.procesar().getId());
    }

    @Test
    public void testColaVacia() {
        CentroDistribucion c = new CentroDistribucion();

        assertNull(c.procesar());
    }
}