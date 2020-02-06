package classi;

import java.util.ArrayList;


public class User {
	String iduser;
	String email;
	String username;
	String password;
	String nreviews;
	String bio;
	String date;
	String region;
	String city;
	boolean Logged;
	ArrayList<Review> WritedReviews;

	
	public boolean isLogged() {
		return Logged;
	}
	public void setLogged(boolean logged) {
		Logged = logged;
	}
	
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNreviews() {
		return nreviews;
	}
	public void setNreviews(String nreviews) {
		this.nreviews = nreviews;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public ArrayList<Review> getWritedReviews() {
		return WritedReviews;
	}
	public void setWritedReviews(ArrayList<Review> writedReviews) {
		WritedReviews = writedReviews;
	}
	
	
}
