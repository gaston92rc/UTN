package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import models.Socio;

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
				ps.setInt(8, socio.getTarjeta().getIdTarjeta());
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
		String query="SELECT s.id, s.nombre,apellido,password,estado,correo,rol, id_tarjeta FROM socios s inner join tarjetas t ON id_tarjeta=t.id AND usuario=? AND password=md5(?) AND estado='activo'LIMIT 1";
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
				s.getTarjeta().setIdTarjeta(rs.getInt("id_tarjeta"));
				
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
}
