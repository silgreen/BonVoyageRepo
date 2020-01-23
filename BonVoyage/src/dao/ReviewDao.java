package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classi.Review;

public class ReviewDao extends Review {

	private Connection con;
	
	public ReviewDao(Connection c) {
		con = c;
	}
	
	public void InsertReviewIntoDb(String iduser, String idpost, String title, String review, int rating) {
		ResultSet result;
		String query = "insert into recensione values (?, ? ,? ,? ,?)";
		int Iduser = Integer.parseInt(iduser);
		int Idpost = Integer.parseInt(idpost);
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(5 , Iduser);
			pst.setInt(1, Idpost);
			pst.setString(2, title);
			pst.setString(3, review);
			pst.setInt(4, rating);
			result = pst.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
