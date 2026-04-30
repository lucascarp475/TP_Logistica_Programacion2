package modelo;

import java.util.PriorityQueue;

public class CentroDistribucion {

    private PriorityQueue<Paquete<?>> cola;

    public CentroDistribucion() {
        cola = new PriorityQueue<>((a, b) -> {
            if (a.esPrioritario() && !b.esPrioritario()) return -1;
            if (!a.esPrioritario() && b.esPrioritario()) return 1;
            return 0;
        });
    }

    public void agregarPaquete(Paquete<?> p) {
        cola.add(p);
    }

    public Paquete<?> procesar() {
        return cola.poll();
    }
}