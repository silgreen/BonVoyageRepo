package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import classi.Review;
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

	int PreviousOpenedFrame;
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
	ArrayList<Post> ResultsList;
	ArrayList<Review> ReviewList;
	User user = new User();
	Post post = new Post();
	String[] SearchParameters = new String[2];
	int SearchType;
	String serverUser;
	String serverPassword;
	String serverHost;
	
	public static void main(String[] args) {
		
		Controller control = new Controller();
	}
	
	public Controller() {
		
		Connection con = null;
		File config = new File("BonVoyage\\src\\connection.config");


		try {
			FileReader reader = new FileReader(config);
			Properties props = new Properties();
			props.load(reader);
			serverHost = props.getProperty("host");
			serverUser = props.getProperty("user");
			serverPassword = props.getProperty("password");
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://"+serverHost+":5432/postgres", serverUser,serverPassword);
			
			
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
		user = UDAO.selectUserInformationsFromDBByUsername(user.getUsername());
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
	
	public  void toFetchReviews(String idpost) {
		ReviewList = REVDAO.toFetchReviewsFromDb(idpost);
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
	    for(int i=0; i<ReviewList.size(); i++) {
	    	if(ReviewList.get(i).getIduser().equals(user.getIduser()))
	    		return true;
	    }
		return false;
	}
	
	public void toShowUserReviews(String iduser) throws NoUserReviewException{
		user.setWritedReviews(REVDAO.toFetchReviewOfUserFromDb(iduser));
		if(REVDAO.toFetchReviewOfUserFromDb(iduser).isEmpty())
			throw new NoUserReviewException();
	}
	
	public void createReview(String iduser,String idpost, String title, String review, int rating) {
		REVDAO.InsertReviewIntoDb(iduser, idpost, title, review, rating);
	}
	
	public void setResultsList() throws NoResultsException {
		if(SearchType == 1) 
			toShowResultsByPositionAndCategory(SearchParameters[0], SearchParameters[1]);	
		else if(SearchType == 2)
			toShowAllResultsByPosition(SearchParameters[0]);
		else if(SearchType == 3)
			toShowResultsByCategory(SearchParameters[0]);
		else if(SearchType == 4)
			toShowAllResults();
	}
	public void setSearchParameters(String city, String category) {
		SearchParameters[0] = city;
		SearchParameters[1] = category;
	}
	
	public void setSearchDataCity(String city) {
		SearchParameters[0] = city;
		SearchParameters[1] = null;
	}
	
	public void setSearchDataCategory(String category) {
		SearchParameters[0] = category;
		SearchParameters[1] = null;
	}
	
	public void toShowResultsByCategory(String category) throws NoResultsException{
		ResultsList = PDAO.toFetchPostFromDbByCategory(category);
		if(ResultsList.isEmpty())
			throw new NoResultsException();
	}
	
	public void toShowAllResults() throws NoResultsException{
		ResultsList = PDAO.toFetchPostFromDb();
		if(ResultsList.isEmpty())
			throw new NoResultsException();
	}
	
	public void toShowResultsByPositionAndCategory(String city, String category) throws NoResultsException{
		ResultsList = PDAO.toFetchPostFromDb(city, category);
		if(ResultsList.isEmpty())
			throw new NoResultsException();
	}
	
	public void toShowAllResultsByPosition(String city) throws NoResultsException{
		ResultsList = PDAO.toFetchPostFromDb(city);
		if(ResultsList.isEmpty())
			throw new NoResultsException();
	}
	
	public void toDeleteUser(String iduser) {
		user.setLogged(false);
		UDAO.toDeleteUserFromDb(iduser);
	}

	public void ModifyBio (String biografia, String username) {
		UDAO.modifyBioFromDB(biografia, username);
	}
	
	public String MatchRegion(String city) {
		String s = POSDAO.MatchRegionDao(city);
		return s;
	}
	
	public void LoginUser(String username, String password) throws LoginException{
			user = UDAO.selectUserInformationsFromDB(username, password);
			if(user.getIduser() != null) {
				user.setLogged(true);
			}
			else throw new LoginException();
	}
	
	public void RegisterUser(String email,String username,String password, String confirmpassword, String region, String city) throws PasswordDismatchException,EmailAlreadyExistException,UserAlreadyExistException {
		
		if(!password.equals(confirmpassword))
			throw new PasswordDismatchException();
		else if(UDAO.AlreadyExistUserInDB(username))
			throw new UserAlreadyExistException();
		else if(UDAO.AlreadyExistEmailInDB(email))
			throw new EmailAlreadyExistException();
		else
			UDAO.insertUserInDb(email, username, password, region, city);
		

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
    
	public String[] getSearchParameters() {
		return SearchParameters;
	}
	
	public UserReviewsFrame getUserReview() {
		return UserReview;
	}

	public ArrayList<Review> getReviewList() {
		return ReviewList;
	}
    
	public void emptyReviewsList() {
		ReviewList.clear();
	}
	
    public ArrayList<Post> getResultsList() {
    	return ResultsList;
    }
    
    public ArrayList<Post> emptyResultsList(){
    	ResultsList.clear();
    	return ResultsList;
    }

    public void LinkPost(Post p) {
    	post = p;
    }
    
	public int getPreviousOpenedFrame() {
		return PreviousOpenedFrame;
	}

	public void setPreviousOpenedFrame(int PreviousOpenedFrame) {
		this.PreviousOpenedFrame = PreviousOpenedFrame;
	}
    
    public Post getPost(){
    	return post;
    }
    
    public void emptyUserReviews(){
    	user.getWritedReviews().clear();
    }
    
    public int getSearchType() {
		return SearchType;
	}

	public void setSearchType(int searchType) {
		SearchType = searchType;
	}
}
