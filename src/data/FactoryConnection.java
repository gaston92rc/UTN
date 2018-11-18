package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class FactoryConnection {
	private static final Logger LOGGER = Logger.getLogger("FactoryConnection");
	private String driver = "com.mysql.jdbc.Driver";
	private String user = "root";
	private String password = "";
	private Connection conn;
	private int cantConn = 0;
	private static FactoryConnection instancia;

	private FactoryConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			LOGGER.severe(""+e);
		}
	}

	public static FactoryConnection getInstancia() {
		if (FactoryConnection.instancia == null) {
			FactoryConnection.instancia = new FactoryConnection();
		}
		return FactoryConnection.instancia;
	}

	public Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/videoclub?user=" + user + "&password="
						+ password + "&useUnicode=true&characterEncoding=UTF-8&collation=utf8_unicode_ci");
			}
		} catch (SQLException e) {
			LOGGER.severe(""+e);
		}
		cantConn++;
		return conn;
	}

	public void releaseConn() {
		try {
			cantConn--;
			if (cantConn == 0) {
				conn.close();
			}

		} catch (SQLException e) {
			LOGGER.severe(""+e);
		}

	}

}
