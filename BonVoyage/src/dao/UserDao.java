package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classi.User;

public class UserDao extends User {
	private Connection con;
	
	public UserDao(Connection c) {
		con = c;
	}
	
	public void insertUserInDb(String email, String username, String password, String region, String city) {
		ResultSet result;
		String query = "insert into utente(email,username,password,regione,città) values(?,?,?,?,?)";
		User user;
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			pst.setString(2,username);
			pst.setString(3,password);
			pst.setString(4,region);
			pst.setString(5,city);
			
			result = pst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
