package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.logging.Logger;

import models.Genero;
import models.Pelicula;


public class DataPelicula {
	
	private static final Logger LOGGER=Logger.getLogger("DataPelicula");

	public List<Pelicula> getByQuery(String busqueda){
		
		String query="SELECT * FROM peliculas WHERE (titulo LIKE ? OR descripcion LIKE ?)";
		PreparedStatement ps=null;
		try {
			
			ps=FactoryConnection.getInstancia().getConn().prepareStatement(query);
			ps.setString(1, "%" + busqueda + "%");
			ps.setString(2, "%" + busqueda + "%");
			List<Pelicula> lista=new LinkedList<>();
			ResultSet rs=ps.executeQuery();
			Pelicula pelicula;
			while(rs.next()) {
				pelicula=new Pelicula(rs.getInt("id"));
				pelicula.setDescripcion(rs.getString("descripcion"));
				pelicula.setDuracion(rs.getString("duracion"));
				pelicula.setTitulo(rs.getString("titulo"));
				Genero genero = new Genero(rs.getInt("id_genero"));
				pelicula.setGenero(genero);
				lista.add(pelicula);	
			}
			return lista;
			
		}catch(Exception e){
			
			LOGGER.severe("ERROR: "+e);	
			return null;
		}finally {
			if (ps != null)
				try {
					ps.close();
					FactoryConnection.getInstancia().releaseConn();
				} catch (SQLException e) {
					LOGGER.severe("ERROR: " + e);
				}		
		}	
	}
	
	public boolean altaPelicula(Pelicula pelicula) {

		String query="INSERT INTO peliculas (duracion,titulo,descripcion,id_genero,imagen) VALUES (?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			
			int row=0;
			
			ps=FactoryConnection.getInstancia().getConn().prepareStatement(query);
			ps.setString(1, pelicula.getDuracion());
			ps.setString(2, pelicula.getTitulo());
			ps.setString(3, pelicula.getDescripcion());
			ps.setInt(4,pelicula.getGenero().getId());
			ps.setString(5, pelicula.getImagen());
			row =ps.executeUpdate();
			
			if(row>0) {
			   return true;
							
			}else {
				return false;
			}
			
		}catch(Exception e) {
			LOGGER.severe("ERROR: "+e);
			return false;
		}finally {
			if (ps!= null)
				try {
					ps.close();
					FactoryConnection.getInstancia().releaseConn();
				} catch (SQLException e) {
					LOGGER.severe("ERROR: " + e);
				}		
		}	
		
	}
	
	public ArrayList<Pelicula> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Pelicula> p= new ArrayList<Pelicula>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT  p.id, titulo, duracion, descripcion, id_genero, denominacion, imagen FROM peliculas p inner join generos g ON id_genero = g.id");
			
			if(rs!=null){
				while(rs.next()){
					Pelicula pelicula=new Pelicula(rs.getInt("id"));					
					pelicula.setDuracion(rs.getString("duracion"));
					pelicula.setTitulo(rs.getString("titulo"));
					pelicula.setDescripcion(rs.getString("descripcion"));
					Genero genero=new Genero(rs.getInt("id_genero"));
					genero.setDenominacion(rs.getString("denominacion"));
					pelicula.setGenero(genero);
					pelicula.setImagen(rs.getString("imagen"));
					System.out.println("Es "+pelicula.getImagen());
					p.add(pelicula);
				}
			}
		    return p;
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
	
	public boolean actualizarPelicula(Pelicula pelicula) {
		
		PreparedStatement ps=null;
		String query="UPDATE peliculas p INNER JOIN generos g ON titulo=? SET duracion=?, descripcion=?, id_genero=?";
		try {
			int row=0;
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);	
			ps.setString(1, pelicula.getTitulo());
			ps.setString(2, pelicula.getDuracion());
			ps.setString(3, pelicula.getDescripcion());
			ps.setInt(4,pelicula.getGenero().getId());
			
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
	
	
	public boolean eliminarPelicula(Pelicula pelicula) {
		PreparedStatement ps=null;
		String query="DELETE FROM peliculas WHERE titulo=?";
		try {
			int row=0;
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);	
			ps.setString(1, pelicula.getTitulo());
			
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

}
