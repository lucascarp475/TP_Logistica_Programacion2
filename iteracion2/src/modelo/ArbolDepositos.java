package modelo;

import java.time.LocalDateTime;

public class ArbolDepositos {

    private NodoABB raiz;

    public void insertar(Deposito deposito) {
        raiz = insertarRec(raiz, deposito);
    }

    private NodoABB insertarRec(NodoABB actual, Deposito deposito) {

        if(actual == null)
            return new NodoABB(deposito);

        if(deposito.getId() < actual.deposito.getId()) {
            actual.izquierdo =
                    insertarRec(actual.izquierdo, deposito);
        }
        else {
            actual.derecho =
                    insertarRec(actual.derecho, deposito);
        }

        return actual;
    }
    
    public void auditar() {
        auditarRec(raiz);
    }

    private void auditarRec(NodoABB nodo) {

        if(nodo == null)
            return;

        auditarRec(nodo.izquierdo);
        auditarRec(nodo.derecho);

        if(nodo.deposito.getFechaUltimaAuditoria()
                .isBefore(LocalDateTime.now().minusDays(30))) {

            nodo.deposito.setVisitado(true);
        }
    }
    
    public void imprimirNivel(int nivel) {
        imprimirNivelRec(raiz, nivel);
    }

    private void imprimirNivelRec(NodoABB nodo, int nivel) {

        if(nodo == null)
            return;

        if(nivel == 0) {
            System.out.println(nodo.deposito.getId());
            return;
        }

        imprimirNivelRec(nodo.izquierdo, nivel - 1);
        imprimirNivelRec(nodo.derecho, nivel - 1);
    }
    
    public Deposito buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Deposito buscarRec(NodoABB actual, int id) {

        if (actual == null) {
            return null;
        }

        if (id == actual.deposito.getId()) {
            return actual.deposito;
        }

        if (id < actual.deposito.getId()) {
            return buscarRec(actual.izquierdo, id);
        }

        return buscarRec(actual.derecho, id);
    }
}