package data;

import java.sql.Date;
import java.sql.PreparedStatement;
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

	public ArrayList<Alquiler> getAlquilerByUsuarioSocio(String usuario) throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Alquiler> a= new ArrayList<Alquiler>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM alquileres a inner join socios s inner join peliculas p inner join generos g WHERE id_pelicula=p.id AND id_socio=s.id AND p.id_genero=g.id AND fechaDevolucion  IS NULL AND usuario='"+usuario+"'");
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
					Alquiler alquiler=new Alquiler(rs.getInt("a.id"), rs.getDouble("importePorDia"), rs.getDate("fechaAlquiler"), rs.getDate("fechaDevolucion"), s, pelicula);			
					
					a.add(alquiler);    
				}
			}
		 return a;
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			
		}finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
		}
		
		}
		return null;
	}

	public ArrayList<Alquiler> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Alquiler> a= new ArrayList<Alquiler>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM alquileres a inner join socios s inner join peliculas p WHERE s.id=id_socio AND p.id=id_pelicula");
			Pelicula pelicula=new Pelicula();
			Socio s=new Socio();
			if(rs!=null){
				while(rs.next()){
					pelicula=new Pelicula(rs.getInt("p.id"));
					pelicula.setDescripcion(rs.getString("descripcion"));
					pelicula.setDuracion(rs.getString("duracion"));
					pelicula.setTitulo(rs.getString("titulo"));
					Genero genero = new Genero(rs.getInt("id_genero"));
					pelicula.setImagen(rs.getString("imagen"));
					pelicula.setAnio(rs.getInt("anio"));
					pelicula.setPais(rs.getString("pais"));
					pelicula.setTrailer(rs.getString("trailer"));
					pelicula.setDetalle(rs.getString("detalle"));
					pelicula.setGenero(genero);
					s.setIdSocio(rs.getInt("s.id"));
					s.setNombre(rs.getString("s.nombre"));
					s.setApellido(rs.getString("apellido"));
					s.setUsername(rs.getString("usuario"));
					s.setPassword(rs.getString("password"));
					s.setEstado(rs.getString("estado"));
					s.setMail(rs.getString("correo"));
					s.setRol(rs.getString("rol"));
					s.setSubscripcion(rs.getInt("subscripcion"));
					Tarjeta tarjeta = new Tarjeta(rs.getInt("id_tarjeta"));
					s.setTarjeta(tarjeta);
					Alquiler alquiler=new Alquiler(rs.getInt("a.id"), rs.getDouble("importePorDia"), rs.getDate("fechaAlquiler"), rs.getDate("fechaDevolucion"), s, pelicula);			
					
					a.add(alquiler);    
				}
			}
			System.out.println(a.size());

			return a;
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			
		}finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
		}
		
		}
		return null;
	}
	
	public boolean eliminarAlquiler(Alquiler alquiler) {
		PreparedStatement ps=null;
		String estado="finalizado";
		String query="UPDATE alquileres SET fechaDevolucion=?, estado=? WHERE id=?";
		try {
			int row=0;
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);	
			ps.setDate(1, (Date) alquiler.getFechaDevolucion());
			ps.setString(2,estado);
			ps.setInt(3, alquiler.getId());
			
			row=ps.executeUpdate();
			if(row>0) {
				   return true;
								
				}else {
					return false;
			}
			
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			
		}finally {
		try {
			if(ps!=null) ps.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
						LOGGER.severe("Error "+e);		}
		
		}
		return false;
		
	}
	
	public ArrayList<Alquiler> getAlquilerByFechaDevolucion() {
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Alquiler> a= new ArrayList<Alquiler>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM alquileres a inner join socios s inner join peliculas p WHERE s.id=id_socio AND p.id=id_pelicula AND fechaDevolucion=''");
			Pelicula pelicula=new Pelicula();
			Socio s=new Socio();
			if(rs!=null){
				while(rs.next()){                 
					pelicula=new Pelicula(rs.getInt("p.id"));
					pelicula.setDescripcion(rs.getString("descripcion"));
					pelicula.setDuracion(rs.getString("duracion"));
					pelicula.setTitulo(rs.getString("titulo"));
					Genero genero = new Genero(rs.getInt("id_genero"));
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
					s.setMail(rs.getString("correo"));
					s.setRol(rs.getString("rol"));
					s.setSubscripcion(rs.getInt("subscripcion"));
					Tarjeta tarjeta = new Tarjeta(rs.getInt("id_tarjeta"));
					s.setTarjeta(tarjeta);
					Alquiler alquiler=new Alquiler(rs.getInt("a.id"), rs.getDouble("importePorDia"), rs.getDate("fechaAlquiler"), rs.getDate("fechaDevolucion"), s, pelicula);			
					
					a.add(alquiler);    
				}
			}
		    return a;
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);			
		}finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);		}
		
		}
		return null;

	}
	
	public boolean actualizarAlquiler(Alquiler alquiler) {
		
		PreparedStatement ps=null;
		String query="UPDATE alquileres SET importePorDia=?";
		try {
			int row=0;
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);	
			ps.setDouble(1, alquiler.getImporte());
			
			row=ps.executeUpdate();
			if(row>0) {
				   return true;
								
				}else {
					return false;
			}
			
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			
		}finally {
		try {
			if(ps!=null) ps.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			LOGGER.severe("Error "+e);		
			}
		
		}
		return true;
		
	}
	
	public boolean actualizarEstadoAlquiler(Alquiler alquiler) {
		
		PreparedStatement ps=null;
		String query="UPDATE alquileres SET estado=? WHERE id=?";
		try {
			int row=0;
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);	
			ps.setString(1, alquiler.getEstado());
			ps.setInt(2, alquiler.getId());
			row=ps.executeUpdate();
			if(row>0) {
				   return true;
								
				}else {
					return false;
			}
			
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			
		}finally {
		try {
			if(ps!=null) ps.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			LOGGER.severe("Error "+e);		
			}
		
		}
		return true;
		
	}
	
	public boolean altaAlquiler(int idPelicula, int idSocio, String titulo, Date fechaAlquiler, String estado) {

		String query="INSERT INTO alquileres (fechaAlquiler, id_socio, id_pelicula, estado) VALUES (?,?,?,?)";
		PreparedStatement ps=null;
		try {		
			int row=0;	
			ps=FactoryConnection.getInstancia().getConn().prepareStatement(query);
			ps.setDate(1, fechaAlquiler);
			ps.setInt(2, idSocio);
			ps.setInt(3,idPelicula);
			ps.setString(4, estado);
			row =ps.executeUpdate();
			
			if(row>0) {
			   return true;
							
			}else {
				return false;
			}
			
		}catch(Exception e) {
			LOGGER.severe("ERROR: "+e);
			
		}finally {
			if (ps!= null)
				try {
					ps.close();
					FactoryConnection.getInstancia().releaseConn();
				} catch (SQLException e) {
					LOGGER.severe("ERROR: " + e);
				}		
		}	
		return false;
		
	}
	

}
