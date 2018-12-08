package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import models.Genero;

public class DataGenero {
	
	private static final Logger LOGGER = Logger.getLogger("DataGenero"); 
	
	public ArrayList<Genero> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Genero> g= new ArrayList<Genero>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM generos");
			if(rs!=null){
				while(rs.next()){
					Genero genero=new Genero();
					genero.setId(rs.getInt("id"));
					genero.setDenominacion(rs.getString("denominacion"));				
					g.add(genero);
				}
			}
		 return g;
		} catch (SQLException e) {
			
			LOGGER.severe("Error "+e);
			return null;
			
		}finally {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConnection.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		}
		
	}
}
