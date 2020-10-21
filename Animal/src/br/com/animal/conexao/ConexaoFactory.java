package br.com.animal.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//DriverManager.getConnection("jdbc:mysql://localhost/animal","root","root");
			return DriverManager.getConnection("jdbc:mysql://localhost/animal?useSSL=false","root","root");

		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
		}
	}
}
