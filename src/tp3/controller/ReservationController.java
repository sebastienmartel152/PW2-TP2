package tp3.controller;

import java.util.ArrayList;

import tp3.model.reservation.AvailabilityChecker;
import tp3.model.reservation.CottageType;
import tp3.model.reservation.MockAvailabilityChecker;
import tp3.model.reservation.Reservation;
import tp3.model.reservation.ReservationBuilder;
import tp3.model.reservation.repository.ReservationRepository;
import tp3.view.DTO.DTOActivities;
import tp3.view.DTO.DTOBaseInfo;
import tp3.view.DTO.DTOContactInfo;
import tp3.view.DTO.DTOReceiptItem;
import tp3.view.DTO.DTOSelectedDate;
import tp3.view.reservation.ReservationActivitiesView;
import tp3.view.reservation.ReservationBaseInfoView;
import tp3.view.reservation.ReservationMainView;
import tp3.view.reservation.ReservationReceiptView;
import tp3.view.reservation.ReservationVerificationView;
import tp3.view.reservation.ReservationView;

public class ReservationController {
	
	private ReservationRepository repository;
	private ReservationBuilder reservationBuilder;
	private ReservationMainView reservationMainView;

	

	private ReservationView currentPanel;
	
	// Pour la vérification de disponibilité
	private int numberOfDays;
	private CottageType cottageType;
	
	// Pour création et affichage de la facture
	private Reservation reservation;
	private DTOSelectedDate selectedDateDTO;
	
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
		
		this.reservationMainView.disableNextButton();
	}

	public boolean checkAvailability(DTOSelectedDate selectedDateDTO) {
		AvailabilityChecker checker = new MockAvailabilityChecker(MockAvailabilityChecker.TRUE);
		
		boolean isAvailable = checker.checkAvailability(selectedDateDTO.selectedDay, selectedDateDTO.selectedMonth, selectedDateDTO.selectedYear,
				this.cottageType, this.numberOfDays);
		
		this.selectedDateDTO = selectedDateDTO;
		return isAvailable;
		
	}

	public void setFinalButton() {
		this.reservationMainView.setFinalButton();
		
	}

	public void receiveContactInfo(DTOContactInfo contactInfoDTO) {
		/* À faire:
		 * Créer l'objet Customer avec les infos du DTO et la date (this.selectedDateDTO) + nombre de jours (this.numberOfDays)
		 * Créer l'objet Receipt avec le Customer et la Reservation (propriété this.reservation déjà présente)
		 * Ajouter la Receipt dans this.repository (qui est à changer en repository de Receipt et non de Reservation)
		 * 
		 * Arranger listItems ci-bas pour avoir les items de la facture
		 */
		
		ArrayList<DTOReceiptItem> listItems = new ArrayList<DTOReceiptItem>();
		listItems.add(new DTOReceiptItem("Chalet 4 personnes", 50.00));
		listItems.add(new DTOReceiptItem("Transport bateau", 30.00));
		
		
		this.reservationMainView.removeNextButton();
		ReservationView receiptView = new ReservationReceiptView(listItems);
		
		this.reservationMainView.setPanel(receiptView);
		this.currentPanel = receiptView;
	}


	
}
