package eus.azterketa.modelo;

public class Corredor {
	private int id;
	private String nombre;
	private String apellido;
	private String nombre_grupo;

	
	public Corredor() {
		super();
	}
	public Corredor(int id, String nombre, String apellido, String nombre_grupo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombre_grupo = nombre_grupo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre_grupo() {
		return nombre_grupo;
	}
	public void setNombre_grupo(String nombre_grupo) {
		this.nombre_grupo = nombre_grupo;
	}
	
	
	

}
