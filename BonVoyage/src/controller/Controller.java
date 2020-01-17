package controller;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import classi.Position;
import dao.PositionDao;
import dao.PostDao;
import dao.UserDao;
import except.PasswordDismatchException;
import forms.LoginFrame;
import forms.PostFrame;
import forms.RegisterFrame;
import forms.ResultsFrame;
import forms.ReviewFrame;
import forms.SearchFrame;

public class Controller {

	SearchFrame Search;
	LoginFrame Login;
	RegisterFrame Register;
	PostFrame Post;
	ResultsFrame Results;
	ReviewFrame Review;
	UserDao UDAO;
	PositionDao POSDAO;

	
	public static void main(String[] args) {
		
		Controller control = new Controller();
	}
	
	public Controller() {
		
		Connection con = null;

		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://vps-zap476015-1.zap-srv.com:5432/postgres", "postgres","Bruttapippa11");
			
			
		} catch (SQLException | ClassNotFoundException e){e.printStackTrace();}

		
		Search = new SearchFrame(this);
		Login = new LoginFrame(this);
	    Register = new RegisterFrame(this);
	    Post = new PostFrame(this);
	    Results = new ResultsFrame(this);
	    Review = new ReviewFrame(this);
	    UDAO = new UserDao(con);
	    POSDAO = new PositionDao(con);
		
	    Search.setVisible(true);
	    
	}
	
	public String MatchRegion(String city) {
		String s = POSDAO.MatchRegionDao(city);
		return s;
	}
	
	public void RegisterUser(String email,String username,String password, String confirmpassword, String region, String city) throws PasswordDismatchException {
		
		if(password.equals(confirmpassword))
			UDAO.insertUserInDb(email, username, password, region, city);
		
		else throw new PasswordDismatchException();
	}
	
	public void toOpenAndCloseFrame(JFrame open, JFrame close) {
		open.setVisible(true);
		close.setVisible(false);
	}
	
	public SearchFrame getSearch() {
		return Search;
	}

	public LoginFrame getLogin() {
		return Login;
	}

	public RegisterFrame getRegister() {
		return Register;
	}

	public PostFrame getPost() {
		return Post;
	}

	public ResultsFrame getResults() {
		return Results;
	}

	public ReviewFrame getReview() {
		return Review;
	}

	public void setSearch(SearchFrame search) {
		Search = search;
	}

	public void setLogin(LoginFrame login) {
		Login = login;
	}

	public void setRegister(RegisterFrame register) {
		Register = register;
	}

	public void setPost(PostFrame post) {
		Post = post;
	}

	public void setResults(ResultsFrame results) {
		Results = results;
	}

	public void setReview(ReviewFrame review) {
		Review = review;
	}
}
