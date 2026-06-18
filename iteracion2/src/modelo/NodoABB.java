package modelo;

public class NodoABB {

    Deposito deposito;

    NodoABB izquierdo;
    NodoABB derecho;

    public NodoABB(Deposito deposito) {
        this.deposito = deposito;
    }
}