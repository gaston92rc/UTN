package models;

public class Tarjeta {
	
	private int id;
	private String nombre;
	
	public Tarjeta(int id) {
		this.id = id;
	}
	
	
	public Tarjeta(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Tarjeta id=" + id + ", nombre=" + nombre;
	}
	
	
	
	
	

}
