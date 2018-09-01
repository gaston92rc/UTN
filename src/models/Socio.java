package models;

public class Socio {

	private int id_socio; 
	private String password;
	private String apellido;
	private String nombre;
	private String estado;
	private String mail;
	private String usuario; 
	private String rol;
	private int id_tarjeta;
	
	

	public Socio(int id_socio, String usuario,String password, String apellido, String nombre, String estado, String mail,String rol,int id_tarjeta) {
		
		this.id_socio = id_socio;
		this.usuario = usuario;
		this.password = password;
		this.apellido = apellido;
		this.nombre = nombre;
		this.estado = estado;
		this.mail = mail;
		this.rol=rol;
		this.id_tarjeta=id_tarjeta;
	}
	
	public int getId_socio() {
		return id_socio;
	}
	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}
	
	public String getUsername() {
		return usuario;
	}
	public void setUsername(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
    
	public int getId_tarjeta() {
		return id_tarjeta;
	}

	public void setId_tarjeta(int id_tarjeta) {
		this.id_tarjeta = id_tarjeta;
	}

	@Override
	public String toString() {
		return "Socio [id_socio=" + id_socio + ", password=" + password + ", apellido=" + apellido + ", nombre="
				+ nombre + ", estado=" + estado + ", mail=" + mail + ", usuario=" + usuario + ", rol=" + rol
				+ ", id_tarjeta=" + id_tarjeta + "]";
	}
		
	
}
