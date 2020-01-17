package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

import classi.User;
import dao.UserDao;
import except.PasswordDismatchException;
import except.UserNotFoundException;
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
	    
	    Search.setVisible(true);
	}
	
	public boolean LoginUser(String username, String password) throws UserNotFoundException{
			User user = UDAO.select_User_Informations_From_DB(username, password);
			if(user.getIduser() != null) {
				user.setLogged(true);
				return true;
			}
			else throw new UserNotFoundException();
	}
	
	public void RegisterUser(String email,String username,String password, String confirmpassword, String region, String city) throws PasswordDismatchException {
		
		if(password.equals(confirmpassword))
			UDAO.insertUserInDb(email, username, password, region, city);
		
		else throw new PasswordDismatchException();
	}
	
	public void toShowRegister() {
		Register.setVisible(true);
		Search.setVisible(false);
	}
	
	public void toShowLogin() {
		Login.setVisible(true);
		Search.setVisible(false);
	}
	
	public void toShowSearchByRegister() {
		Register.setVisible(false);
		Search.setVisible(true);
	}
	
	public void toShowSearchBylogin() {
		Login.setVisible(false);
		Search.setVisible(true);
	}
}
