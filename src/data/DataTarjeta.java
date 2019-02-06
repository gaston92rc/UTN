package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import models.Tarjeta;

public class DataTarjeta {

private static final Logger LOGGER = Logger.getLogger("DataTarjeta");

public ArrayList<Tarjeta> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Tarjeta> t= new ArrayList<Tarjeta>();
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM tarjetas WHERE id <> 1");
			
			if(rs!=null){
				while(rs.next()){
					Tarjeta tarjeta=new Tarjeta(rs.getInt("id"), rs.getString("nombre"));					
					t.add(tarjeta);
				}
			}
		    return t;
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

	public Tarjeta getById(int id) throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		Tarjeta tarjeta = null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM tarjetas WHERE id <> 1");
			
			if(rs!=null){
				while(rs.next()){
				   tarjeta=new Tarjeta(rs.getInt("id"), rs.getString("nombre"));					
				}
			}
		    return tarjeta;
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

}
