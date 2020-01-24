package controller;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classi.Review;
import classi.Position;
import dao.PositionDao;
import dao.PostDao;
import dao.ReviewDao;
import classi.User;
import dao.UserDao;
import except.EmailAlreadyExistException;
import except.LoginException;
import except.NoResultsException;
import except.PasswordDismatchException;
import except.UserAlreadyExistException;
import forms.LoginFrame;
import forms.PostFrame;
import forms.ProfileFrame;
import forms.RegisterFrame;
import forms.ResultsFrame;
import forms.ReviewFrame;
import forms.SearchFrame;
import panel.ResultPanel;
import classi.Post;
public class Controller {

	int story;
	SearchFrame Search;
	LoginFrame Login;
	RegisterFrame Register;
	PostFrame Post;
	ResultsFrame Results;
	ReviewFrame Review;
	ProfileFrame Profile;
	UserDao UDAO;
	PostDao PDAO;
	PositionDao POSDAO;
	ReviewDao REVDAO;
	ArrayList<Post> ap;
	ArrayList<Review> ar;
	User user = new User();
	Post post = new Post();
	
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
	    Profile = new ProfileFrame(this);
	    UDAO = new UserDao(con);
	    POSDAO = new PositionDao(con);
	    PDAO = new PostDao(con);
	    REVDAO = new ReviewDao(con);
		
	    Search.setVisible(true);
	    
	}
	
	public  void toShowReview(String idpost) {
		ar = REVDAO.toFetchReviewsFromDb(idpost);
	}


	public int StoryFrame(JFrame p) {
		int search = 1;
		int results= 2;
		int pnumber = 3;
		
		if (p.equals(Search)) {
			return search;
		} else if (p.equals(Results)) {
			return results;
		} else if (p.equals(Post)) {
			return pnumber;
		} 
		return search;
	}
	
	public void createReview(String iduser,String idpost, String title, String review, int rating) {
		REVDAO.InsertReviewIntoDb(iduser, idpost, title, review, rating);
	}
	
	public void toShowResultsByCategory(String category) throws NoResultsException{
		ap = PDAO.toFetchPostFromDbByCategory(category);
		if(ap.isEmpty())
			throw new NoResultsException();
	}
	
	public void toShowAllResults() throws NoResultsException{
		ap = PDAO.toFetchPostFromDb();
		if(ap.isEmpty())
			throw new NoResultsException();
	}
	
	public void toShowResultsByPositionAndCategory(String city, String category) throws NoResultsException{
		ap = PDAO.toFetchPostFromDb(city, category);
		if(ap.isEmpty())
			throw new NoResultsException();
	}
	
	public void toShowAllResultsByPosition(String city) throws NoResultsException{
		ap = PDAO.toFetchPostFromDb(city);
		if(ap.isEmpty())
			throw new NoResultsException();
	}
	
	public void toDeleteUser(String iduser) {
		UDAO.toDeleteUserFromDb(iduser);
	}

	public void ModifyBio (String biografia, String username) {
		UDAO.modify_Bio_From_DB(biografia, username);
	}
	
	public String MatchRegion(String city) {
		String s = POSDAO.MatchRegionDao(city);
		return s;
	}
	
	public User Login_User(String username, String password) throws LoginException{
			user = UDAO.select_User_Informations_From_DB(username, password);
			if(user.getIduser() != null) {
				user.setLogged(true);
				return user;
			}
			else throw new LoginException();
	}
	
	public void RegisterUser(String email,String username,String password, String confirmpassword, String region, String city) throws PasswordDismatchException,EmailAlreadyExistException,UserAlreadyExistException {
		
		if(password.equals(confirmpassword))
			UDAO.insertUserInDb(email, username, password, region, city);
		
		else throw new PasswordDismatchException();
	}
	
	public void toOpenAndCloseFrame(JFrame open, JFrame close) {
		open.setVisible(true);
		open.setBounds(close.getX(), close.getY(), close.getWidth(), close.getHeight());
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

	public PostFrame getPostFrame() {
		return Post;
	}

	public ResultsFrame getResults() {
		return Results;
	}

	public ReviewFrame getReview() {
		return Review;
	}
	
	public ProfileFrame getProfile() {
		return Profile;
	}
	
    public User getUser() {
		return user;
	}
    
	
	public ArrayList<Review> getReviewList() {
		return ar;
	}
    
	public void emptyReviewsList() {
		ar.clear();
	}
	
    public ArrayList<Post> getPostsArrayList() {
    	return ap;
    }
    
    public ArrayList<Post> emptyPosts(){
    	ap.clear();
    	return ap;
    }

    public void LinkPost(Post p) {
    	post = p;
    }
    
	public int getStory() {
		return story;
	}

	public void setStory(int story) {
		this.story = story;
	}
    
    public Post getPost(){
    	return post;
    }
    public void SetLoginAndRegisterLabelVisible(boolean loginAndRegister, boolean User) {
    	Search.getContentPane().getComponent(8).setVisible(loginAndRegister);
    	Search.getContentPane().getComponent(9).setVisible(loginAndRegister);
    	Search.getContentPane().getComponent(10).setVisible(loginAndRegister);
    	Search.getContentPane().getComponent(11).setVisible(User);
    	Search.getContentPane().getComponent(12).setVisible(User);

    }
}
