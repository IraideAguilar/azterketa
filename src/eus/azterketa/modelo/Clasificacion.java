package eus.azterketa.modelo;

public class Clasificacion {

	private int id_corredor;
	private int id_etapa;
	private int posicion;
	

	public Clasificacion() {
		super();
	}
	public Clasificacion(int id_corredor, int id_etapa, int posicion) {
		super();
		this.id_corredor = id_corredor;
		this.id_etapa = id_etapa;
		this.posicion = posicion;
	}
	public int getId_corredor() {
		return id_corredor;
	}
	public void setId_corredor(int id_corredor) {
		this.id_corredor = id_corredor;
	}
	public int getId_etapa() {
		return id_etapa;
	}
	public void setId_etapa(int id_etapa) {
		this.id_etapa = id_etapa;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	
	
}
