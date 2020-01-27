package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classi.Review;

public class ReviewDao extends Review {

	
	private Connection con;
	
	public ReviewDao(Connection c) {
		con = c;
	}
	
	public ArrayList<Review> toFetchReviewOfUserFromDb(String iduser){
		ArrayList<Review> aReview = new ArrayList<Review>();
		Review r;
		int pid = Integer.parseInt(iduser);
		ResultSet result;
		String query = "select * from recensione inner join utente on utente.idutente = recensione.idutente where recensione.idutente = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, pid);
			result = pst.executeQuery();
			
			
			
			while(result.next()) {
				r = new Review();
				r.setUsername(result.getString("username"));
				r.setIdpost(result.getString("idpost"));
				r.setIduser(result.getString("idutente"));
				r.setTitle(result.getString("titolo"));
				r.setText(result.getString("testo"));
				r.setRating(result.getInt("rating_utente"));
				aReview.add(r);
			}
			
			return aReview;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Review> toFetchReviewsFromDb(String postid){
		ArrayList<Review> aReview  = new ArrayList<Review>();
		Review r;
		int pid = Integer.parseInt(postid);
		ResultSet result;
		String query = "select * from recensione inner join utente on utente.idutente = recensione.idutente where idpost = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, pid);
			result = pst.executeQuery();
			
			
			
			while(result.next()) {
				r = new Review();
				r.setUsername(result.getString("username"));
				r.setIdpost(result.getString("idpost"));
				r.setIduser(result.getString("idutente"));
				r.setTitle(result.getString("titolo"));
				r.setText(result.getString("testo"));
				r.setRating(result.getInt("rating_utente"));
				aReview.add(r);
			}
			
			return aReview;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
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
