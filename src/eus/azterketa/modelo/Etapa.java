package eus.azterketa.modelo;

public class Etapa {
	
	private int id;
	private int n_etapa;
	private int km;
	private String pueblo_salida;
	private String pueblo_llegada;
	

	
	public Etapa() {
		super();
	}
	public Etapa(int id, int n_etapa, int km, String pueblo_salida, String pueblo_llegada) {
		super();
		this.id = id;
		this.n_etapa = n_etapa;
		this.km = km;
		this.pueblo_salida = pueblo_salida;
		this.pueblo_llegada = pueblo_llegada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getN_etapa() {
		return n_etapa;
	}
	public void setN_etapa(int n_etapa) {
		this.n_etapa = n_etapa;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public String getPueblo_salida() {
		return pueblo_salida;
	}
	public void setPueblo_salida(String pueblo_salida) {
		this.pueblo_salida = pueblo_salida;
	}
	public String getPueblo_llegada() {
		return pueblo_llegada;
	}
	public void setPueblo_llegada(String pueblo_llegada) {
		this.pueblo_llegada = pueblo_llegada;
	}
	
	

}
