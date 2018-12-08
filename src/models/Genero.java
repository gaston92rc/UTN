package models;

public class Genero {
	
	private int id;
	private String denominacion;
	
	public Genero(int id) {
		this.id = id;
	}
	
	public Genero() {
		
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
