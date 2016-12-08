package tp3.controller;

import tp3.model.reservation.ReservationBuilder;
import tp3.model.reservation.repository.ReservationRepository;
import tp3.view.DTO.DTOBaseInfo;
import tp3.view.reservation.ReservationActivitiesView;
import tp3.view.reservation.ReservationBaseInfoView;
import tp3.view.reservation.ReservationMainView;
import tp3.view.reservation.ReservationView;

public class ReservationController {
	
	private ReservationRepository repository;
	private ReservationBuilder reservationBuilder;
	private ReservationMainView reservationMainView;
	
	public ReservationController(ReservationRepository repository){
		this.repository = repository;
	}
	
	public void displayWindow(){
		ReservationView baseInfoView = new ReservationBaseInfoView(this);

		this.reservationMainView = new ReservationMainView(baseInfoView);
		
		reservationMainView.setVisible(true);
	}

	public void receiveBaseInfo(DTOBaseInfo baseInfo) {
		this.reservationBuilder = new ReservationBuilder(baseInfo.cottageType, baseInfo.numberOfPeople,
				baseInfo.numberOfNights, baseInfo.transportTo, baseInfo.transportBack);
		
		if(baseInfo.breakfastDinnerOption){
			this.reservationBuilder.withBreakfastDinner();
		}
		
		if(baseInfo.gastronomicSupperOption){
			this.reservationBuilder.withGastronomicSupper();
		}
		
		displayActivityPanel();
	}

	private void displayActivityPanel() {
		ReservationView activityPanel = new ReservationActivitiesView(this);
		
		this.reservationMainView.setPanel(activityPanel);
	}
	
	
	
}
