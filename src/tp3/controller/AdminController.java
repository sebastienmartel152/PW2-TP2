package tp3.controller;

import tp3.model.reservation.repository.ReservationRepository;
import tp3.view.admin.AdminView;

public class AdminController {
	
	private ReservationRepository repository;
	
	private AdminView adminView;
	
	public AdminController(ReservationRepository repository){
		this.repository = repository;
		this.adminView = new AdminView(this);
	}
	
	public void displayWindow(){
		this.adminView.setVisible(true);
	}
	
	

}