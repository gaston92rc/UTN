package models;

public class Alquiler {
	
	private int id;	
	private double importePorDia;
	private String fechaAlquiler;
	private String fechaDevolucion;
	private Socio socio;
	private Pelicula pelicula;
	
	
	public Alquiler(int id, double importePorDia, String fechaAlquiler, String fechaDevolucion, Socio socio, Pelicula pelicula) {
		
		this.id = id;
		this.importePorDia = importePorDia;
		this.fechaAlquiler = fechaAlquiler;
		this.fechaDevolucion = fechaDevolucion;
		this.pelicula = pelicula;
		this.socio = socio;
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
	public String getFechaAlquiler() {
		return fechaAlquiler;
	}
	public void setFechaAlquiler(String fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}
	public String getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(String fechaDevolucion) {
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


	
}
