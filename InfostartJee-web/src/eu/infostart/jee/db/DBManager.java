package eu.infostart.jee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://54.154.189.117:3306/infostart";
	// Database credentials
	static final String USER = "infostart";
	static final String PASS = "infostart";

	public boolean checkValidUser(String username, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.prepareStatement("select * from Users where username = ? and password = ?");
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				String email = rs.getString("email");
				System.out.println(email);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
