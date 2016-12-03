package tp3.controller;

import tp3.model.reservation.repository.ReservationRepository;
import tp3.view.WelcomeView;

public class WelcomeController {
	
	private ReservationRepository repository;
	private ReservationController reservationController;
	
	public WelcomeController(ReservationRepository repository) {
		this.repository = repository;
		this.reservationController = new ReservationController(this.repository);
	}
	
	public void startApplication(){
		WelcomeView welcomeView = new WelcomeView(this);
		welcomeView.setVisible(true);
	}
	
	public void showAdminView() {
		
		
	}

	public void showReservationView() {
		this.reservationController.displayWindow();
		
	}

}
