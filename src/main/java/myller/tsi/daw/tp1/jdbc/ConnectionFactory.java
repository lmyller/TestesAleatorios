package myller.tsi.daw.tp1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utilizada para criar a conex�o com o banco de dados.
public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost/testes", "postgres", "postgres");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
