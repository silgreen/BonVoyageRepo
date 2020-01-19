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
		String query = "insert into utente(email,username,password,regione,citt�) values(?,?,?,?,?)";
		
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
	
	public User select_User_Informations_From_DB(String username, String password) {
		ResultSet result;
		User user;
		String query = "select * from utente where username = ? and password = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			result = pst.executeQuery();
			
			user = new User();
			while(result.next()) {
				user.setIduser(result.getString(1));
				user.setEmail(result.getString(2));
				user.setUsername(result.getString(3));
				user.setNreviews(result.getString(5));
				user.setRank(result.getString(6));
				user.setBio(result.getString(7));
				user.setDate(result.getString(8));
				user.setRegion(result.getString(9));
				user.setCity(result.getString(10));
			}
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void modify_Bio_From_DB (String biografia, String username) {
		ResultSet result;
		String newBio;
		String query = "update utente set biografia = ? where username = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, biografia);
			pst.setString(2, username);
			
			result = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
