package tp3.controller;

import tp3.model.reservation.repository.ReservationRepository;
import tp3.view.WelcomeView;

public class WelcomeController {
	
	private ReservationRepository repository;
	
	public WelcomeController(ReservationRepository repository) {
		this.repository = repository;
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
