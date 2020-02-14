package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classi.Post;

public class PostDao extends Post{
	private Connection con;
	
	public PostDao(Connection c) {
		con = c;
	}
	
	public Post toFetchSinglePostFromDb(String idpost){
		ResultSet result;
		Post p;
		String query = "select * from post inner join struttura on post.strutturaid = struttura.idstruttura where idpost = ?";
		int id = Integer.parseInt(idpost);
		
		try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, id);
				result = pst.executeQuery();
				
				result.next();
				p = new Post();
				p.setURLMedia(result.getString("media"));
				p.setAddress(result.getString("indirizzo"));
				p.setCategory(result.getString("categoria"));
				p.setCity(result.getString("citta"));
				p.setIdpost(result.getString("idpost"));
				p.setInfo(result.getString("info"));
				p.setName(result.getString("nome"));
				p.setNreviews(result.getString("nrecensioni"));
				p.setRating_avg(result.getString("rating_avg"));
				p.setRegion(result.getString("regione"));
				p.setStars(result.getString("stelle"));
				p.setSub_category(result.getString("tipologia"));
				p.setTel(result.getString("telefono"));
				return p;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Post> toFetchPostFromDb(String city, String category){
		ResultSet result;
		Post p;
		ArrayList<Post> ap = new ArrayList<Post>();
		String query = "select * from post inner join struttura on post.strutturaid = struttura.idstruttura where citta=? "
						+ "and categoria =?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, city);
			pst.setString(2,category);
			
			result = pst.executeQuery();
			
			while(result.next()) {
				p = new Post();
				p.setURLMedia(result.getString("media"));
				p.setAddress(result.getString("indirizzo"));
				p.setCategory(result.getString("categoria"));
				p.setCity(result.getString("citta"));
				p.setIdpost(result.getString("idpost"));
				p.setInfo(result.getString("info"));
				p.setName(result.getString("nome"));
				p.setNreviews(result.getString("nrecensioni"));
				p.setRating_avg(result.getString("rating_avg"));
				p.setRegion(result.getString("regione"));
				p.setStars(result.getString("stelle"));
				p.setSub_category(result.getString("tipologia"));
				p.setTel(result.getString("telefono"));
				
				ap.add(p);
			}
			return ap;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Post> toFetchPostFromDb(){
		ResultSet result;
		Post p;
		ArrayList<Post> ap = new ArrayList<Post>();
		String query = "select * from post inner join struttura on post.strutturaid = struttura.idstruttura";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			
			result = pst.executeQuery();
			
			while(result.next()) {
				p = new Post();
				p.setURLMedia(result.getString("media"));
				p.setAddress(result.getString("indirizzo"));
				p.setCategory(result.getString("categoria"));
				p.setCity(result.getString("citta"));
				p.setIdpost(result.getString("idpost"));
				p.setInfo(result.getString("info"));
				p.setName(result.getString("nome"));
				p.setNreviews(result.getString("nrecensioni"));
				p.setRating_avg(result.getString("rating_avg"));
				p.setRegion(result.getString("regione"));
				p.setStars(result.getString("stelle"));
				p.setSub_category(result.getString("tipologia"));
				p.setTel(result.getString("telefono"));
				
				ap.add(p);
			}
			return ap;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Post> toFetchPostFromDb(String city){
		ResultSet result;
		Post p;
		ArrayList<Post> ap = new ArrayList<Post>();
		String query = "select * from post inner join struttura on post.strutturaid = struttura.idstruttura where citta=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, city);
			
			result = pst.executeQuery();
			
			while(result.next()) {
				p = new Post();
				p.setURLMedia(result.getString("media"));
				p.setAddress(result.getString("indirizzo"));
				p.setCategory(result.getString("categoria"));
				p.setCity(result.getString("citta"));
				p.setIdpost(result.getString("idpost"));
				p.setInfo(result.getString("info"));
				p.setName(result.getString("nome"));
				p.setNreviews(result.getString("nrecensioni"));
				p.setRating_avg(result.getString("rating_avg"));
				p.setRegion(result.getString("regione"));
				p.setStars(result.getString("stelle"));
				p.setSub_category(result.getString("tipologia"));
				p.setTel(result.getString("telefono"));
				
				ap.add(p);
			}
			return ap;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Post> toFetchPostFromDbByCategory(String category){
		ResultSet result;
		Post p;
		ArrayList<Post> ap = new ArrayList<Post>();
		String query = "select * from post inner join struttura on post.strutturaid = struttura.idstruttura where categoria=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, category);
			
			result = pst.executeQuery();
			
			while(result.next()) {
				p = new Post();
				p.setURLMedia(result.getString("media"));
				p.setAddress(result.getString("indirizzo"));
				p.setCategory(result.getString("categoria"));
				p.setCity(result.getString("citta"));
				p.setIdpost(result.getString("idpost"));
				p.setInfo(result.getString("info"));
				p.setName(result.getString("nome"));
				p.setNreviews(result.getString("nrecensioni"));
				p.setRating_avg(result.getString("rating_avg"));
				p.setRegion(result.getString("regione"));
				p.setStars(result.getString("stelle"));
				p.setSub_category(result.getString("tipologia"));
				p.setTel(result.getString("telefono"));
				
				ap.add(p);
			}
			return ap;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
