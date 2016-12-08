package tp3.controller;

import tp3.model.reservation.repository.ReservationRepository;
import tp3.view.WelcomeView;

public class WelcomeController {
	
	private ReservationRepository repository;
	private ReservationController reservationController;
	private AdminController adminController;
	
	public WelcomeController(ReservationRepository repository) {
		this.repository = repository;
		this.reservationController = new ReservationController(this.repository);
		this.adminController = new AdminController(this.repository);
	}
	
	public void startApplication(){
		WelcomeView welcomeView = new WelcomeView(this);
		welcomeView.setVisible(true);
	}
	
	public void showAdminView() {
		this.adminController.displayWindow();
		
	}

	public void showReservationView() {
		this.reservationController.displayWindow();
		
	}

}