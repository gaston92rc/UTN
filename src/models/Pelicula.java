package models;


public class Pelicula {
	
	private int id;
	private String titulo;
	private String descripcion;
	private String duracion;
	private Genero genero;
	private String imagen;
	
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Pelicula(String titulo, String descripcion, String duracion, Genero genero, String imagen) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.genero = genero;
		this.imagen = imagen;
	}
	
	public Pelicula(int id) {
		this.setId(id);
	}
	
	public Pelicula(String titulo) {
		this.setTitulo(titulo);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	

}
