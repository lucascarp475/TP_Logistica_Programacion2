package main;

import modelo.Camion;
import modelo.CentroDistribucion;
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

        // simular procesamiento
        
        Paquete<?> p;

        while ((p = centro.procesar()) != null) {

            camion.cargar(p); // lo cargo en el camión

            System.out.println("Cargado en camión: " + p);
        }
        System.out.println("Cantidad de paquetes: " + paquetes.size());
    }
}