package modelo;

public class Cliente {
	private Integer id;
	private String nombre;
	private String paterno;
	private String materno;

	public Cliente(Integer id, String nombre, String paterno, String materno) {
		this.id = id;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

}
