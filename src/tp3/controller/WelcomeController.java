package tp3.controller;

import tp3.view.WelcomeView;

public class WelcomeController {
	
	public WelcomeController() {

	}
	
	public void startApplication(){
		WelcomeView welcomeView = new WelcomeView(this);
		welcomeView.setVisible(true);
	}
	
	public void showAdminView() {
		
		
	}

	public void showReservationView() {
		
		
	}

}
