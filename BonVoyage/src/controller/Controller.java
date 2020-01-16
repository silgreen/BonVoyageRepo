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

	public static void main(String[] args) {
		
		Controller control = new Controller();
		SearchFrame Search = new SearchFrame(control);
		LoginFrame Login = new LoginFrame(control);
	    RegisterFrame Register = new RegisterFrame(control);
	    PostFrame Post = new PostFrame(control);
	    ResultsFrame Results = new ResultsFrame(control);
	    ReviewFrame Review = new ReviewFrame(control);
	    Search.setVisible(true);
	}
	
	public Controller() {
		
		Connection con = null;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			
			
		} catch (SQLException | ClassNotFoundException e){e.printStackTrace();}
		
	}

}
