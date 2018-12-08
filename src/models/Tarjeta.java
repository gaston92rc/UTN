package models;

public class Tarjeta {
	
	private int id;
	private String nombre;
	
	public Tarjeta(int id) {
		super();
		this.id = id;
	}
	
	public Tarjeta() {
	}
	
	public int getId() {
		return id;
	}
	public void setIdTarjeta(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

}
