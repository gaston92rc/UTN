package models;

public class Socio {

	private int idSocio; 
	private String password;
	private String apellido;
	private String nombre;
	private String estado;
	private String mail;
	private String usuario; 
	private String rol;
	private int idTarjeta;
	
	

	public Socio(int idSocio, String usuario,String password, String apellido, String nombre, String estado, String mail,String rol,int idTarjeta) {
		this.idSocio = idSocio;
		this.usuario = usuario;
		this.password = password;
		this.apellido = apellido;
		this.nombre = nombre;
		this.estado = estado;
		this.mail = mail;
		this.rol = rol;
		this.idTarjeta = idTarjeta;
	}
	
	
	public Socio(String usuario,String password, String apellido, String nombre, String estado, String mail,String rol,int idTarjeta) {
		this.password = password;
		this.apellido = apellido;
		this.nombre = nombre;
		this.estado = estado;
		this.mail = mail;
		this.usuario = usuario;
		this.rol = rol;
		this.idTarjeta = idTarjeta;
	}


	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
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
    
	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	@Override
	public String toString() {
		return "Socio [id_socio=" + idSocio + ", password=" + password + ", apellido=" + apellido + ", nombre="
				+ nombre + ", estado=" + estado + ", mail=" + mail + ", usuario=" + usuario + ", rol=" + rol
				+ ", id_tarjeta=" + idTarjeta + "]";
	}
		
	
}
