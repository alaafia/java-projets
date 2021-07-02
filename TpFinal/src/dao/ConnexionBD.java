package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	final static String driverClassName="com.mysql.jdbc.Driver";
	final static String URL = "jdbc:sqlite:/Users/aichalaafia/eclipse-workspace/TpFinal/tpFinal.db";
	final static String Login = "root";
	final static String Password = "root";
	
	
	//Une méthode  Connexion static connexion().
	
	public ConnexionBD() {
		
	}
	// La classe ConnexionBD doit respecter le Pattern singleton
	public static Connection getConnexion() {
		 Connection conn=null;
		  try {
			conn=DriverManager.getConnection(URL,Login,Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return conn;
	 }
}