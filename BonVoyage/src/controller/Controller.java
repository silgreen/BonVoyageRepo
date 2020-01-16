package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	
	public static void main(String[] args) {
		
		Controller control = new Controller();
	}
	
	public Controller() {
		
		Connection con = null;

		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			
			
		} catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
		
		Search = new SearchFrame(this);
		Login = new LoginFrame(this);
	    Register = new RegisterFrame(this);
	    Post = new PostFrame(this);
	    Results = new ResultsFrame(this);
	    Review = new ReviewFrame(this);
	    Search.setVisible(true);
	}
	
	public void toShowRegisterFrame() {
		Register.setVisible(true);
		Search.setVisible(false);
	}
	
	public void toShowLogin() {
		Login.setVisible(true);
		Search.setVisible(false);
	}

}
