package modelo;

import java.util.Stack;

public class Camion {
    private Stack<Paquete<?>> carga;

    public Camion() {
        carga = new Stack<>();
    }

    public void cargar(Paquete<?> p) {
        carga.push(p);
    }

    public Paquete<?> descargar() {
        return carga.pop();
    }

    public void deshacerCarga() {
        if (!carga.isEmpty()) {
            carga.pop();
        }
    }
    
    public boolean estaVacio() {
        return carga.isEmpty();
    }
}