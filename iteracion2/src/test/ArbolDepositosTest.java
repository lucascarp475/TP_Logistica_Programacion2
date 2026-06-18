package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import modelo.ArbolDepositos;
import modelo.Deposito;

public class ArbolDepositosTest {
	@Test
	public void testInsertar() {
	    ArbolDepositos arbol = new ArbolDepositos();

	    arbol.insertar(new Deposito(50,"A"));
	    arbol.insertar(new Deposito(20,"B"));

	    assertNotNull(arbol.buscar(20));
	}
	
	@Test
	public void testBuscarInexistente() {

	    ArbolDepositos arbol = new ArbolDepositos();

	    assertNull(arbol.buscar(99));
	}
}
