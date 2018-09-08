package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import models.Socio;

public class DataSocio {
	private static final Logger LOGGER = Logger.getLogger("DataSocio");
	public boolean register(Socio socio) {
		
		String query = "INSERT INTO socios (nombre, apellido, usuario, password, estado, correo, rol, id_Tarjeta)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;  
		
		try {
			ps=FactoryConnection.getInstancia().getConn().prepareStatement(query);
			ps.setString(1, socio.getNombre());
			ps.setString(2, socio.getApellido());
			ps.setString(3, socio.getUsername());
			ps.setString(4, socio.getPassword());
			ps.setString(5, socio.getEstado());
			ps.setString(6, socio.getMail());
			ps.setString(7,socio.getRol());
			ps.setInt(8, socio.getIdTarjeta());
			ps.execute();
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
					LOGGER.severe("ERROR: "+e);
				}
			
		}
	}

}
