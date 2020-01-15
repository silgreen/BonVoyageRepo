package controller;

import forms.SearchFrame;

public class Controller {

	public static void main(String[] args) {
		
		Controller control = new Controller();
		SearchFrame Search = new SearchFrame(control);
		Search.setVisible(true);
	}

}
