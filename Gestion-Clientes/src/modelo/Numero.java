package modelo;

public class Numero {
	
	public enum Estado {
		asignado, baja, disponible;
	}
	
	private String numero;
	private Estado estado;
	
	public Numero(String numero, Estado estado) {
		this.numero = numero;
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
