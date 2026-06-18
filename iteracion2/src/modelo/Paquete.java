package modelo;

public class Paquete<T> {
    private String id;
    private double peso;
    private String destino;
    private T contenido;
    private boolean urgente;
    private String zonaDestino;

    public Paquete(String id, double peso, String destino, String zonaDestino, T contenido, boolean urgente) {
        this.id = id;
        this.peso = peso;
        this.destino = destino;
        this.zonaDestino = zonaDestino;
        this.contenido = contenido;
        this.urgente = urgente;
    }

	public boolean esPrioritario() {
        return urgente || peso > 50;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public T getContenido() {
		return contenido;
	}

	public void setContenido(T contenido) {
		this.contenido = contenido;
	}

	public boolean isUrgente() {
		return urgente;
	}

	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}
	
	public String getZonaDestino() {
	    return zonaDestino;
	}

	public void setZonaDestino(String zonaDestino) {
	    this.zonaDestino = zonaDestino;
	}
	
	@Override
	public String toString() {
	    return "Paquete{" +
	            "id='" + id + '\'' +
	            ", peso=" + peso +
	            ", destino='" + destino + '\'' +
	            ", zona='" + zonaDestino + '\'' +
	            ", urgente=" + urgente +
	            '}';
	}
}
