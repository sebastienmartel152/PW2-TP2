package tp3.controller;

import tp3.model.reservation.repository.ReservationRepository;
import tp3.view.DTO.DTOBaseInfo;
import tp3.view.reservation.ReservationBaseInfoView;
import tp3.view.reservation.ReservationMainView;
import tp3.view.reservation.ReservationView;

public class ReservationController {
	
	private ReservationRepository repository;
	
	public ReservationController(ReservationRepository repository){
		this.repository = repository;
	}
	
	public void displayWindow(){
		ReservationView baseInfoView = new ReservationBaseInfoView(this);

		ReservationMainView reservationMainView = new ReservationMainView(baseInfoView);
		
		reservationMainView.setVisible(true);
	}

	public void baseInfo(DTOBaseInfo baseInfo) {
		
	}
	
}
