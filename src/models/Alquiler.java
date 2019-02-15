package models;

import java.util.Date;

public class Alquiler {
	
	private int id;	
	private double importePorDia;
	private Date fechaAlquiler;
	private Date fechaDevolucion;
	private Socio socio;
	private Pelicula pelicula;
	private String estado;	
	
	public Alquiler(int id, double importePorDia, Date fechaAlquiler, Date fechaDevolucion, Socio socio, Pelicula pelicula) {
		
		this.id = id;
		this.importePorDia = importePorDia;
		this.fechaAlquiler = fechaAlquiler;
		this.fechaDevolucion = fechaDevolucion;
		this.pelicula = pelicula;
		this.socio = socio;
	}
	
	public Alquiler(int id, Date fechaDevolucion) {
		
		this.id = id;
		this.fechaDevolucion=fechaDevolucion;
	}
	
	public Alquiler(double importePorDia) {
		
		this.importePorDia=importePorDia;
	}
	
    public Alquiler() {
			
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getImporte() {
		return importePorDia;
	}
	public void setImporte(double importePorDia) {
		this.importePorDia = importePorDia;
	}
	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}
	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	
}
