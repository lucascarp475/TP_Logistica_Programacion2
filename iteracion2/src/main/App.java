package main;

import modelo.Camion;
import modelo.CentroDistribucion;
import modelo.Gestor;
import modelo.Grafo;
import modelo.Paquete;
import service.JsonLoader;

public class App {
    public static void main(String[] args) {

        CentroDistribucion centro = new CentroDistribucion();
        Camion camion = new Camion();

        var paquetes = JsonLoader.cargar();

        for (Paquete<?> p : paquetes) {
            centro.agregarPaquete(p);
        }
        
        Paquete<?> p;

        while ((p = centro.procesar()) != null) {

            camion.cargar(p); 

            System.out.println("Cargado en camión: " + p);
        }
        System.out.println("Cantidad de paquetes: " + paquetes.size());
        
        Grafo grafo = new Grafo();

        grafo.agregarDeposito(50);
        grafo.agregarDeposito(20);
        grafo.agregarDeposito(80);
        grafo.agregarDeposito(30);

        grafo.conectar(50, 20);
        grafo.conectar(20, 80);
        grafo.conectar(80, 30);

        grafo.mostrarConexiones();

        System.out.println(
            "Saltos entre 50 y 30: "
            + grafo.cantidadSaltos(50, 30)
        );
    }
}