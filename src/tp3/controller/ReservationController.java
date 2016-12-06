package tp3.controller;

import tp3.model.reservation.repository.ReservationRepository;
import tp3.view.reservation.ReservationBaseInfoView;
import tp3.view.reservation.ReservationMainView;

public class ReservationController {
	
	private ReservationRepository repository;
	
	private ReservationMainView reservationMainView;
	private ReservationBaseInfoView baseInfoView;
	
	public ReservationController(ReservationRepository repository){
		this.repository = repository;
		
		this.baseInfoView = new ReservationBaseInfoView(this);
		
		this.reservationMainView = new ReservationMainView(this, this.baseInfoView);
	}
	
	public void displayWindow(){
		this.reservationMainView.setVisible(true);
		
		this.reservationMainView.setPanel(baseInfoView);
	}

	public void displayNextPanel() {
		
		
	}
	
}
