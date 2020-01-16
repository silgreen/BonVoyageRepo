package controller;

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
		Search.setVisible(true);
	}

}
