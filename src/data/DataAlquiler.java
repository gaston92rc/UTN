package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import models.Alquiler;
import models.Genero;
import models.Pelicula;
import models.Socio;
import models.Tarjeta;

public class DataAlquiler {
	
private static final Logger LOGGER = Logger.getLogger("DataAlquiler"); 

	public ArrayList<Alquiler> getAlquilerByIdSocio(int id) throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Alquiler> a= new ArrayList<Alquiler>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM alquileres a inner join socios s inner join peliculas p inner join generos g WHERE id_pelicula=p.id AND id_socio=s.id AND p.id_genero=g.id AND fechaDevolucion  IS NOT NULL");
			Pelicula pelicula=new Pelicula();
			Socio s=new Socio();
			if(rs!=null){
				while(rs.next()){
					pelicula=new Pelicula(rs.getInt("p.id"));
					pelicula.setDescripcion(rs.getString("descripcion"));
					pelicula.setDuracion(rs.getString("duracion"));
					pelicula.setTitulo(rs.getString("titulo"));
					Genero genero = new Genero(rs.getInt("id_genero"));
					genero.setDenominacion(rs.getString("denominacion"));
					pelicula.setImagen(rs.getString("imagen"));
					pelicula.setAnio(rs.getInt("anio"));
					pelicula.setPais(rs.getString("pais"));
					pelicula.setTrailer(rs.getString("trailer"));
					pelicula.setDetalle(rs.getString("detalle"));
					pelicula.setGenero(genero);
					s.setIdSocio(rs.getInt("s.id"));
					s.setNombre(rs.getString("nombre"));
					s.setApellido(rs.getString("apellido"));
					s.setUsername(rs.getString("usuario"));
					s.setPassword(rs.getString("password"));
					s.setEstado(rs.getString("estado"));
					s.setUsername(rs.getString("correo"));
					s.setUsername(rs.getString("rol"));
					s.setSubscripcion(rs.getInt("subscripcion"));
					Tarjeta tarjeta = new Tarjeta(rs.getInt("id_tarjeta"));
					s.setTarjeta(tarjeta);
					Alquiler alquiler=new Alquiler(rs.getInt("a.id"), rs.getDouble("importePorDia"), rs.getString("fechaAlquiler"), rs.getString("fechaDevolucion"), s, pelicula);			
					
					a.add(alquiler);    
				}
			}
		 return a;
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			return null;
			
		}finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
		}
		
		}
		
	}

	public ArrayList<Alquiler> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Alquiler> a= new ArrayList<Alquiler>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM alquileres a inner join socios s inner join peliculas p");
			Pelicula pelicula=new Pelicula();
			Socio s=new Socio();
			if(rs!=null){
				while(rs.next()){
					pelicula=new Pelicula(rs.getInt("p.id"));
					pelicula.setDescripcion(rs.getString("descripcion"));
					pelicula.setDuracion(rs.getString("duracion"));
					pelicula.setTitulo(rs.getString("titulo"));
					Genero genero = new Genero(rs.getInt("id_genero"));
					genero.setDenominacion(rs.getString("denominacion"));
					pelicula.setImagen(rs.getString("imagen"));
					pelicula.setAnio(rs.getInt("anio"));
					pelicula.setPais(rs.getString("pais"));
					pelicula.setTrailer(rs.getString("trailer"));
					pelicula.setDetalle(rs.getString("detalle"));
					pelicula.setGenero(genero);
					s.setIdSocio(rs.getInt("s.id"));
					s.setNombre(rs.getString("nombre"));
					s.setApellido(rs.getString("apellido"));
					s.setUsername(rs.getString("usuario"));
					s.setPassword(rs.getString("password"));
					s.setEstado(rs.getString("estado"));
					s.setUsername(rs.getString("correo"));
					s.setUsername(rs.getString("rol"));
					s.setSubscripcion(rs.getInt("subscripcion"));
					Tarjeta tarjeta = new Tarjeta(rs.getInt("id_tarjeta"));
					s.setTarjeta(tarjeta);
					Alquiler alquiler=new Alquiler(rs.getInt("a.id"), rs.getDouble("importePorDia"), rs.getString("fechaAlquiler"), rs.getString("fechaDevolucion"), s, pelicula);			
					
					a.add(alquiler);    
				}
			}
		 return a;
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			return null;
			
		}finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
		}
		
		}
		
	}

}
