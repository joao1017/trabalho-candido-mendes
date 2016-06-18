package br.com.controlealuno.connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionJDBC implements Serializable {

	private static final long serialVersionUID = 1L;
	static ConnectionJDBC instance;
	static final ResourceBundle dbProperties = ResourceBundle.getBundle("DB");

	private ConnectionJDBC() {

	}

	public static synchronized ConnectionJDBC getInstance() {
		if (instance == null)
			instance = new ConnectionJDBC();

		return instance;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(getDriver());
		return DriverManager.getConnection(getUrl(), getUser(), getPassword());
	}

	protected String getDriver() {
		return dbProperties.getString("driver");
	}

	protected String getUrl() {
		return dbProperties.getString("url");
	}

	protected String getUser() {
		return dbProperties.getString("user");
	}

	protected String getPassword() {
		return dbProperties.getString("password");
	}
}