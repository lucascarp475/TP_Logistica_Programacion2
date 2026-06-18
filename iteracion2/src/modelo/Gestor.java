package modelo;

public class Gestor {
    private Nodo primero;

    public Gestor() {
        this.primero = null;
    }

    public Nodo buscar(int idDeposito) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.getIdDeposito() == idDeposito) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void agregar(int idDeposito) {
        Nodo nuevo = new Nodo(idDeposito);
        if (primero == null) {
            primero = nuevo;
            return;
        }
        Nodo actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }

    public static class Nodo {
        private final int idDeposito;
        private Nodo siguiente;

        public Nodo(int idDeposito) {
            this.idDeposito = idDeposito;
        }

        public int getIdDeposito() {
            return idDeposito;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
}
