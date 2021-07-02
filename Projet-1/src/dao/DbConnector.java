package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

	// create a connection to the database
	final static  String connectionUrl = "jdbc:sqlite:/Users/aichalaafia/Desktop/Projet-1/resources/proj_java.db";
	static Connection conn = null;

	public static  void connect() {

		try {
			// db parameters

			conn = DriverManager.getConnection(connectionUrl);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		if (conn == null)
			connect();
		return conn;

	}

}