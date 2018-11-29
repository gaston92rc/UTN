package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import java.util.logging.Logger;
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
				pelicula.getGenero().setId(rs.getInt("id_genero"));
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

}
