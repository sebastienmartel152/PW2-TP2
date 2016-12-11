package tp3.controller;

import java.util.Date;

import tp3.model.reservation.AvailabilityChecker;
import tp3.model.reservation.CottageType;
import tp3.model.reservation.MockAvailabilityChecker;
import tp3.model.reservation.Reservation;
import tp3.model.reservation.ReservationBuilder;
import tp3.model.reservation.repository.ReservationRepository;
import tp3.view.DTO.DTOActivities;
import tp3.view.DTO.DTOBaseInfo;
import tp3.view.DTO.DTOContactInfo;
import tp3.view.DTO.DTOSelectedDate;
import tp3.view.reservation.ReservationActivitiesView;
import tp3.view.reservation.ReservationBaseInfoView;
import tp3.view.reservation.ReservationMainView;
import tp3.view.reservation.ReservationVerificationView;
import tp3.view.reservation.ReservationView;

public class ReservationController {
	
	private ReservationRepository repository;
	private ReservationBuilder reservationBuilder;
	private ReservationMainView reservationMainView;

	private Reservation reservation;

	private ReservationView currentPanel;
	
	// Pour la v�rification de disponibilit�
	private int numberOfDays;
	private CottageType cottageType;
	
	public ReservationController(ReservationRepository repository){
		this.repository = repository;
	}
	
	public void displayWindow(){
		ReservationView baseInfoView = new ReservationBaseInfoView(this);
		this.currentPanel = baseInfoView;
		

		this.currentPanel = baseInfoView;

		reservationMainView = new ReservationMainView(this, baseInfoView);
		reservationMainView.setVisible(true);
	}
	
	public void nextPanel(){
		this.currentPanel.sendInformation();
	}
	
	public void receiveBaseInfo(DTOBaseInfo baseInfo) {
		this.numberOfDays = baseInfo.numberOfNights;
		this.cottageType = baseInfo.cottageType;
		
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

		this.currentPanel = activityPanel;
	}
	
	public void receiveActivitiesInfo(DTOActivities activitiesInfo){
		
		if(activitiesInfo.blackBearObservation){
			this.reservationBuilder.withBlackBearObservationActivity();
		}
		
		if(activitiesInfo.flyFishing){
			this.reservationBuilder.withFishingActivity();
		}
		
		if(activitiesInfo.wolfObservation){
			this.reservationBuilder.withWolfObservationActivity();
		}
		
		this.reservation = this.reservationBuilder.build();
		
		displayConfirmationPanel();
	}
	
	private void displayConfirmationPanel(){
		double totalCost = this.reservation.calculateTotalCost();

		ReservationView confirmationPanel = new ReservationVerificationView(this, totalCost);
		
		this.reservationMainView.setPanel(confirmationPanel);
		this.currentPanel = confirmationPanel;
		
		this.reservationMainView.setNextButtonEnabled(false);
	}

	public boolean checkAvailability(DTOSelectedDate selectedDateDTO) {
		AvailabilityChecker checker = new MockAvailabilityChecker(MockAvailabilityChecker.TRUE);
		
		boolean isAvailable = checker.checkAvailability(selectedDateDTO.selectedDay, selectedDateDTO.selectedMonth, selectedDateDTO.selectedYear,
				this.cottageType, this.numberOfDays);
		
		return isAvailable;
		
	}

	public void setFinalButton() {
		this.reservationMainView.setFinalButton();
		this.reservationMainView.setNextButtonEnabled(true);
		
	}

	public void receiveContactInfo(DTOContactInfo contactInfoDTO) {
		/* � faire:
		 * Cr�er l'objet Customer � partir des infos du DTO
		 * Cr�er l'objet Receipt avec le Customer et la Reservation (propri�t� this.reservation d�j� pr�sente)
		 * Ajouter la Receipt dans this.repository (qui a �t� chang� en repository de Receipt et non de Reservation
		 */
		
		
		
	}
	
}
