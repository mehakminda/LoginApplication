package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	String url="jdbc:mysql://localhost:3306/LoginApp";
	String dbuser="student1";
	String dbPass="student1";
	String sqlQuery="select * from login where uname=? and pass=?";
	
	public boolean checkCredentials(String username, String password) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,dbuser,dbPass);
			PreparedStatement stmt= conn.prepareStatement(sqlQuery);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

}
