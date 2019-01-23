package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import models.Genero;
import models.Pelicula;
import models.Socio;
import models.Tarjeta;

public class DataSocio {
	private static final Logger LOGGER = Logger.getLogger("DataSocio");

	public boolean register(Socio socio) {
		String query = "INSERT INTO socios (nombre, apellido, usuario, password, estado, correo, rol, id_Tarjeta)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		if (!existSocio(socio)) {
			try {
				ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);
				ps.setString(1, socio.getNombre());
				ps.setString(2, socio.getApellido());
				ps.setString(3, socio.getUsername());
				ps.setString(4, socio.getPassword());
				ps.setString(5, socio.getEstado());
				ps.setString(6, socio.getMail());
				ps.setString(7, socio.getRol());
				ps.setInt(8, socio.getTarjeta().getId());
				ps.execute();
				return true;
			} catch (SQLException e) {
				LOGGER.severe("ERROR: " + e);
				return false;
			} finally {
				if (ps != null)
					try {
						ps.close();
						FactoryConnection.getInstancia().releaseConn();
					} catch (SQLException e) {
						LOGGER.severe("ERROR: " + e);
					}

			}
		}
		return false;
	}

	public boolean existSocio(Socio socio) {

		String query = "SELECT 1 FROM socios WHERE usuario = ?";

		PreparedStatement ps = null;

		try {
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);
			ps.setString(1, socio.getUsername());
			ResultSet rs = ps.executeQuery();
			return rs.next();

		} catch (Exception e) {
			LOGGER.severe(""+e);
			return false;
		}finally {
			if(ps!=null) {
				try {
					ps.close();
					FactoryConnection.getInstancia().releaseConn();
				} catch (SQLException e) {
					LOGGER.severe("ERROR: " + e);
				}
			}
		}
	}
	
	public Socio login(String usuario, String password) {
		PreparedStatement ps = null;
		String query="SELECT s.id, s.nombre,apellido, usuario, password,estado,correo,rol, id_tarjeta FROM socios s inner join tarjetas t ON id_tarjeta=t.id AND usuario=? AND password=? AND estado='activo'LIMIT 1";
		try {
			ps=FactoryConnection.getInstancia().getConn().prepareStatement(query);
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			Socio s=new Socio(0); //Si existe le asigno luego su Id.
			while(rs.next() && rs!=null) {	
				
				s.setIdSocio(rs.getInt("id"));
				s.setNombre(rs.getString("nombre"));
				s.setApellido(rs.getString("apellido"));
				s.setUsername(rs.getString("usuario"));
				s.setPassword(rs.getString("password"));
				s.setEstado(rs.getString("estado"));
				s.setUsername(rs.getString("correo"));
				s.setUsername(rs.getString("rol"));
				Tarjeta tarjeta = new Tarjeta(rs.getInt("id_tarjeta"));
				s.setTarjeta(tarjeta);
				
			}
			return s;
				
		} catch (SQLException e) {
			LOGGER.severe("ERROR: " + e);
			return null;
		} finally {
			if (ps != null)
				try {
					ps.close();
					FactoryConnection.getInstancia().releaseConn();
				} catch (SQLException e) {
					LOGGER.severe("ERROR: " + e);
				}
		}
	}
	
	public ArrayList<Socio> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Socio> s= new ArrayList<Socio>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT s.id, s.nombre, apellido, usuario, password, estado, correo, rol, id_tarjeta, t.nombre FROM socios s inner join tarjetas t ON id_tarjeta = t.id");
			
			if(rs!=null){
				while(rs.next()){
					Socio socio=new Socio(rs.getInt("id"));					
					socio.setNombre(rs.getString("s.nombre"));
					socio.setApellido(rs.getString("apellido"));
					socio.setEstado(rs.getString("estado"));
					socio.setMail(rs.getString("correo"));
					socio.setRol(rs.getString("rol"));
					socio.setUsername(rs.getString("usuario"));
					socio.setPassword(rs.getString("password"));
					Tarjeta tarjeta=new Tarjeta(rs.getInt("id_tarjeta"));
					tarjeta.setNombre(rs.getString("t.nombre"));
					socio.setTarjeta(tarjeta);
					s.add(socio);
				}
			}
		    return s;
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			return null;
			
		}finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);		}
		
		}
		
	}
	
	
	public ArrayList<Socio> getSancionado(){
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Socio> s= new ArrayList<Socio>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM socios s inner join tarjetas t ON id_tarjeta = t.id AND estado='Sancionado'");
			
			if(rs!=null){
				while(rs.next()){
					Socio socio=new Socio(rs.getInt("id"));					
					socio.setNombre(rs.getString("s.nombre"));
					socio.setApellido(rs.getString("apellido"));
					socio.setEstado(rs.getString("estado"));
					socio.setMail(rs.getString("correo"));
					socio.setRol(rs.getString("rol"));
					socio.setUsername(rs.getString("usuario"));
					socio.setPassword(rs.getString("password"));
					Tarjeta tarjeta=new Tarjeta(rs.getInt("id_tarjeta"));
					tarjeta.setNombre(rs.getString("t.nombre"));
					socio.setTarjeta(tarjeta);
					s.add(socio);
				}
			}
		    return s;
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			return null;
			
		}finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);		}
		
		}
		
		
	}

	public boolean altaSancionados(Socio socio) {
		PreparedStatement ps = null;
		String query="SELECT 1 FROM socios WHERE id=?";
			try {
				ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);
				ps.setInt(1, socio.getIdSocio());
				ResultSet rs = ps.executeQuery();
				this.actualizarEstadoSocio(socio);
				return true;

			} catch (Exception e) {
				LOGGER.severe("Error "+e);
				return false;
			}finally {
				if(ps!=null) {
					try {
						ps.close();
						FactoryConnection.getInstancia().releaseConn();
					} catch (SQLException e) {
						LOGGER.severe("ERROR: " + e);
					}
				}
			}
	}
	
	public boolean actualizarEstadoSocio(Socio socio) {
		
		PreparedStatement ps=null;
		String query="UPDATE socios SET estado=?";
		try {
			int row=0;
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);	
			ps.setString(1, socio.getEstado());
		
			
			row=ps.executeUpdate();
			if(row>0) {
				   return true;
								
				}else {
					return false;
			}
			
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			return true;
			
		}finally {
		try {
			if(ps!=null) ps.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			LOGGER.severe("Error "+e);		
			}
		
		}
		
	}
	
	public boolean actualizarSocio(Socio socio) {
		
		PreparedStatement ps=null;
		String query="UPDATE peliculas p INNER JOIN generos g ON titulo=? SET duracion=?, descripcion=?, id_genero=?";
		try {
			int row=0;
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);	
			ps.setString(1, socio.getNombre());
		
			
			row=ps.executeUpdate();
			if(row>0) {
				   return true;
								
				}else {
					return false;
			}
			
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			return false;
			
		}finally {
		try {
			if(ps!=null) ps.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
						LOGGER.severe("Error "+e);		}
		
		}
		
	}
	
	public boolean eliminarSocio(Socio socio) {
		PreparedStatement ps=null;
		String query="DELETE FROM socios WHERE usuario=?";
		try {
			int row=0;
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);	
			ps.setString(1, socio.getUsername());
			
			row=ps.executeUpdate();
			if(row>0) {
				   return true;
								
				}else {
					return false;
			}
			
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			return false;
			
		}finally {
		try {
			if(ps!=null) ps.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			LOGGER.severe("Error "+e);		
			}
		
		}
		
	}

}
