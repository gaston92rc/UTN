package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Socio;

public class DataSocio {
	
	public boolean register(Socio socio) {
		
		String sql="INSERT INTO 'socios' VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=null;  
		
		try {
		
			ps=FactoryConnection.getInstancia().getConn().prepareStatement(sql);
			ps.setInt(1, socio.getId_socio());
			ps.setString(2, socio.getNombre());
			ps.setString(3, socio.getApellido());
			ps.setString(4, socio.getUsername());
			ps.setString(5, socio.getPassword());
			ps.setString(6, socio.getEstado());
			ps.setString(7, socio.getMail());
			ps.setString(8,socio.getRol());
			ps.setInt(9, socio.getId_tarjeta());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
		finally {
			if(ps!=null)
				try {
					ps.close();
					FactoryConnection.getInstancia().releaseConn();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
	}

}
