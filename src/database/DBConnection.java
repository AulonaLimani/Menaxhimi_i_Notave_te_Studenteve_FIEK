package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection dbConnection;
	
	private final static String host = System.getenv("DB_HOST");
	private final static String dbName = System.getenv("DB_NAME");
	private final static String username = System.getenv("DB_USERNAME");
	private final static String password = System.getenv("DB_PASSWORD");
	
	public static Connection getConnection() {
		if(dbConnection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConnection = 
						DriverManager.getConnection("jdbc:mysql://localhost:3306/knk2", "root","");
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return dbConnection;
	}

}
