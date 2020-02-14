package controller;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
import except.NoUserReviewException;
import except.PasswordDismatchException;
import except.UserAlreadyExistException;
import forms.LoginFrame;
import forms.PostFrame;
import forms.ProfileFrame;
import forms.RegisterFrame;
import forms.ResultsFrame;
import forms.ReviewFrame;
import forms.SearchFrame;
import forms.UserReviewsFrame;
import panel.ResultPanel;
import classi.Post;
public class Controller {

	int story;
	UserReviewsFrame UserReview;
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
	String[] SearchDatas = new String[2];
	int SearchType;
	
	public static void main(String[] args) {
		
		Controller control = new Controller();
	}
	
	public Controller() {
		
		Connection con = null;

		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://vps-zap476015-1.zap-srv.com:5432/postgres", "postgres","Bruttapippa11");
			
			
		} catch (SQLException | ClassNotFoundException e){e.printStackTrace();}

		UserReview = new UserReviewsFrame(this);
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
	
	
	public void updateUserDatas() {
		user = UDAO.select_User_Informations_From_DB_By_Username(user.getUsername());
		user.setLogged(true);
	}
	
	public void toShowStars(JLabel l, float rating) {
		if(rating == 0)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/stellevuote.png")));
		else if(rating >= 1.5 && rating < 2)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/1emezza.png")));
		else if (rating >= 1 && rating < 1.5)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/1stella.png")));
		else if (rating >= 2.5 && rating < 3)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/2emezza.png")));
		else if (rating >= 2 && rating < 2.5)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/2stelle.png")));
		else if (rating >= 3.5 && rating < 4)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/3emezza.png")));
		else if (rating >= 3 && rating < 3.5)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/3stelle.png")));
		else if (rating >= 4.5 && rating < 5)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/4emezza.png")));
		else if (rating >= 4 && rating < 4.5)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/4stelle.png")));
		else if (rating > 4.5)
			l.setIcon(new ImageIcon(ResultPanel.class.getResource("/images/5stelle.png")));
	}
	
	public void UpdateUserReview(String newReview, String iduser, String idpost) {
		REVDAO.updateReview(newReview, iduser, idpost);
	}
	
	public Post toFetchSinglePost(String idpost) {
		post = PDAO.toFetchSinglePostFromDb(idpost);
		return post;
	}
	
	public void toDeleteReview(String idpost,String iduser) {
		REVDAO.toDeleteReviewFromDb(idpost, iduser);
	}
	
	public  void toShowReview(String idpost) {
		ar = REVDAO.toFetchReviewsFromDb(idpost);
	}


	public int StoryFrame(JFrame frame) {
		int search = 1;
		int results= 2;
		int pnumber = 3;
		
		if (frame.equals(Search)) {
			return search;
		} else if (frame.equals(Results)) {
			return results;
		} else if (frame.equals(Post)) {
			return pnumber;
		} 
		return search;
	}
	
	public boolean controlIfExistsReviewInPostWithLoggedIduser() {
	    for(int i=0; i<ar.size(); i++) {
	    	if(ar.get(i).getIduser().equals(user.getIduser()))
	    		return true;
	    }
		return false;
	}
	
	public void toShowUserReview(String iduser) throws NoUserReviewException{
		user.setWritedReviews(REVDAO.toFetchReviewOfUserFromDb(iduser));
		if(REVDAO.toFetchReviewOfUserFromDb(iduser).isEmpty())
			throw new NoUserReviewException();
	}
	
	public void createReview(String iduser,String idpost, String title, String review, int rating) {
		REVDAO.InsertReviewIntoDb(iduser, idpost, title, review, rating);
	}
	
	public void setPostsArrayList() throws NoResultsException {
		if(SearchType == 1) 
			toShowResultsByPositionAndCategory(SearchDatas[0], SearchDatas[1]);	
		else if(SearchType == 2)
			toShowAllResultsByPosition(SearchDatas[0]);
		else if(SearchType == 3)
			toShowResultsByCategory(SearchDatas[0]);
		else if(SearchType == 4)
			toShowAllResults();
	}
	public void setSearchDatas(String city, String category) {
		SearchDatas[0] = city;
		SearchDatas[1] = category;
	}
	
	public void setSearchDataCity(String city) {
		SearchDatas[0] = city;
		SearchDatas[1] = null;
	}
	
	public void setSearchDataCategory(String category) {
		SearchDatas[0] = category;
		SearchDatas[1] = null;
	}
	
	public String[] getSearchDatas() {
		return SearchDatas;
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
    
	
	public UserReviewsFrame getUserReview() {
		return UserReview;
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
    
    public void emptyReview(){
    	user.getWritedReviews().clear();
    }
    
    public int getSearchType() {
		return SearchType;
	}

	public void setSearchType(int searchType) {
		SearchType = searchType;
	}

	public void SetLoginAndRegisterLabelVisible(boolean loginAndRegister, boolean User) {
    	Search.getContentPane().getComponent(11).setVisible(loginAndRegister);
    	Search.getContentPane().getComponent(12).setVisible(loginAndRegister);
    	Search.getContentPane().getComponent(13).setVisible(loginAndRegister);
    	Search.getContentPane().getComponent(14).setVisible(User);
    	Search.getContentPane().getComponent(15).setVisible(User);

    }
}
