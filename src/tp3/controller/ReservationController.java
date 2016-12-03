package tp3.controller;

import javax.swing.JFrame;

import tp3.model.reservation.repository.ReservationRepository;

public class ReservationController {
	
	private ReservationRepository repository;
	private JFrame ReservationMainView;
	
	public ReservationController(ReservationRepository repository){
		this.repository = repository;
		this.ReservationMainView = new tp3.view.reservation.ReservationMainView(this);
	}
	
	public void displayWindow(){
		this.ReservationMainView.setVisible(true);
	}

	public void displayNextPanel() {
		
		
	}
	
}
