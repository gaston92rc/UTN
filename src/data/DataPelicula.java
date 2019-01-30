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
				pelicula.setImagen(rs.getString("imagen"));
				pelicula.setAnio(rs.getInt("anio"));
				pelicula.setPais(rs.getString("pais"));
				pelicula.setTrailer(rs.getString("trailer"));
				pelicula.setDetalle(rs.getString("detalle"));
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
	
	public ArrayList<Pelicula> getByDetalle(String detalle){
		
		String query="SELECT  p.id, titulo, duracion, descripcion, id_genero, denominacion, imagen, pais, trailer, anio, detalle FROM peliculas p inner join generos g ON (id_genero = g.id AND detalle=?)";
		PreparedStatement ps=null;
		try {
			
			ps=FactoryConnection.getInstancia().getConn().prepareStatement(query);
			ps.setString(1, detalle );
			ArrayList<Pelicula> lista=new ArrayList<>();
			ResultSet rs=ps.executeQuery();
			Pelicula pelicula;
			while(rs.next()) {
				pelicula=new Pelicula(rs.getInt("id"));
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

		String query="INSERT INTO peliculas (duracion,titulo,descripcion,id_genero,imagen,anio,pais,trailer,detalle) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			
			int row=0;
			
			ps=FactoryConnection.getInstancia().getConn().prepareStatement(query);
			ps.setString(1, pelicula.getDuracion());
			ps.setString(2, pelicula.getTitulo());
			ps.setString(3, pelicula.getDescripcion());
			ps.setInt(4,pelicula.getGenero().getId());
			ps.setString(5, pelicula.getImagen());
			ps.setInt(6, pelicula.getAnio());
			ps.setString(7,pelicula.getTrailer());
			ps.setString(8,pelicula.getPais());
			ps.setString(9, pelicula.getDetalle());
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
			rs = stmt.executeQuery("SELECT  p.id, titulo, duracion, descripcion, id_genero, denominacion, imagen, anio, pais, trailer, detalle FROM peliculas p inner join generos g ON id_genero = g.id");
			
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
					pelicula.setAnio(rs.getInt("anio"));
					pelicula.setPais(rs.getString("pais"));
					pelicula.setTrailer(rs.getString("trailer"));
					pelicula.setDetalle(rs.getString("detalle"));
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
	
	public ArrayList<Pelicula> getByInicial(String inicial) throws Exception{
		
		String query="SELECT  p.id, titulo, duracion, descripcion, id_genero, denominacion, imagen, pais, trailer, anio, detalle FROM peliculas p inner join generos g ON (id_genero = g.id AND titulo LIKE ?)";
		PreparedStatement ps=null;
		try {
			ps=FactoryConnection.getInstancia().getConn().prepareStatement(query);
			ps.setString(1, inicial + "%");
			ArrayList<Pelicula> lista=new ArrayList<>();
			ResultSet rs=ps.executeQuery();
			Pelicula pelicula;
			while(rs.next()) {
				pelicula=new Pelicula(rs.getInt("id"));
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
	
	
	public boolean actualizarPelicula(Pelicula pelicula) {
		
		PreparedStatement ps=null;
		String query="UPDATE peliculas p INNER JOIN generos g ON titulo=? SET duracion=?, descripcion=?, id_genero=?, anio=?, pais=?, trailer=?, detalle=?";
		try {
			int row=0;
			ps = FactoryConnection.getInstancia().getConn().prepareStatement(query);	
			ps.setString(1, pelicula.getTitulo());
			ps.setString(2, pelicula.getDuracion());
			ps.setString(3, pelicula.getDescripcion());
			ps.setInt(4,pelicula.getGenero().getId());
			ps.setInt(5,pelicula.getAnio());
			ps.setString(6, pelicula.getPais());
			ps.setString(7, pelicula.getTrailer());
			ps.setString(8, pelicula.getDetalle());
			
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
	
	public int getByCantPeliculas() {
		
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM peliculas");			
			 int contador = 0;
			 
			 if(rs!=null){
				 while(rs.next()){ 
					 contador++;	
				 }
			 }
			 return contador;
			 
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			return 0;
			
		}finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);		}
		
		}
		
	}
	
	public ArrayList<Pelicula> getByOrdenAlfabetico(){	
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Pelicula> p= new ArrayList<Pelicula>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM peliculas ORDER BY titulo ASC");
			
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
					pelicula.setPais(rs.getString("pais"));
					pelicula.setTrailer(rs.getString("trailer"));
					pelicula.setAnio(rs.getInt("anio"));
					pelicula.setDetalle(rs.getString("detalle"));
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
	
	public ArrayList<Pelicula> getByPaisPelicula(){	
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Pelicula> p= new ArrayList<Pelicula>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT DISTINCT pais FROM peliculas");
			
			if(rs!=null){
				while(rs.next()){
					Pelicula pelicula=new Pelicula();					
					pelicula.setPais(rs.getString("pais"));
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
