package it.polito.tdp.anagrammiDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	// check user e password
		static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=riccardogasso";

		public static Connection getConnection() {

			try {
					Connection connection = DriverManager.getConnection(jdbcUrl);
					return connection;

			} catch (SQLException e) {

				e.printStackTrace();
				throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
			}
		}


}
