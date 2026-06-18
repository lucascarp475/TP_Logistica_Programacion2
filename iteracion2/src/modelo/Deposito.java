package modelo;

import java.time.LocalDateTime;

public class Deposito {

    private int id;
    private String nombre;
    private boolean visitado;
    private LocalDateTime fechaUltimaAuditoria;

    public Deposito(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.visitado = false;
        this.fechaUltimaAuditoria = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public LocalDateTime getFechaUltimaAuditoria() {
        return fechaUltimaAuditoria;
    }
}