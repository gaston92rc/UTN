package models;

public class Genero {
	
	private int id;
	private String denominacion;
	
	public Genero() {
	}
		
	
	
	
	public Genero(String denominacion) {
		this.denominacion = denominacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	

}
