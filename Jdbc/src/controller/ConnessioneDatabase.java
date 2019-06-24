package controller;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;



public class ConnessioneDatabase {
	
	public static final String DRIVERDB = "com.mysql.jdbc.Driver";
	public static final String CONNDB = "jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false";
	public static final String DATABASEUSER = "root";
	public static final String DBPASS = "corso";
	
	public static Connection getTheConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(DRIVERDB);
			conn = (Connection) DriverManager.getConnection(CONNDB, DATABASEUSER, DBPASS);
			//System.out.println("Connessione effettuata");
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println("Connessione nulla");
			conn.close();
		}
		return conn;
	}

}
