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
	
	public User selectUserInformationsFromDBByUsername(String username) {
		ResultSet result;
		User user;
		String query = "select * from utente where username = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, username);
			result = pst.executeQuery();
			
			user = new User();
			while(result.next()) {
				user.setIduser(result.getString(1));
				user.setEmail(result.getString(2));
				user.setUsername(result.getString(3));
				user.setNreviews(result.getString(5));
				user.setBio(result.getString(6));
				user.setDate(result.getString(7));
				user.setRegion(result.getString(8));
				user.setCity(result.getString(9));
			}
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean AlreadyExistEmailInDB (String email){
		ResultSet result;
		String query = "select email from utente where email = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			result = pst.executeQuery();
			
			while(result.next()) {
				if(result.getString(1).equals(email)) 
					return true;
			}
		} catch (SQLException e) {}
		return false;
	}
	
	public boolean AlreadyExistUserInDB (String username){
		String res = null;
		ResultSet result;
		String query = "select username from utente where username = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, username);
			result = pst.executeQuery();
			
			while(result.next()) {
				if(result.getString(1).equals(username)) 
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void toDeleteUserFromDb(String userid) {
		String query = "delete from utente where idutente = ?";
		int i = Integer.parseInt(userid);
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,i);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertUserInDb(String email, String username, String password, String region, String city) {
		String query = "insert into utente(email,username,password,regione,citta) values(?,?,?,?,?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			pst.setString(2,username);
			pst.setString(3,password);
			pst.setString(4,region);
			pst.setString(5,city);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User selectUserInformationsFromDB(String username, String password) {
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
				user.setBio(result.getString(6));
				user.setDate(result.getString(7));
				user.setRegion(result.getString(8));
				user.setCity(result.getString(9));
			}
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void modifyBioFromDB (String biografia, String username) {
		String newBio;
		String query = "update utente set biografia = ? where username = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, biografia);
			pst.setString(2, username);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
