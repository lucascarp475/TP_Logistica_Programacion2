package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.Grafo;

public class GrafoTest {
	@Test
	public void testConexion() {

	    Grafo g = new Grafo();

	    g.agregarDeposito(1);
	    g.agregarDeposito(2);

	    g.conectar(1,2);

	    assertEquals(1,
	        g.cantidadSaltos(1,2));
	}
	
	@Test
	public void testSinCamino() {

	    Grafo g = new Grafo();

	    g.agregarDeposito(1);
	    g.agregarDeposito(2);

	    assertEquals(-1,
	        g.cantidadSaltos(1,2));
	}
}
