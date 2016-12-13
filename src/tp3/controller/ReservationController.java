package tp3.controller;

import java.util.ArrayList;

import tp3.model.reservation.AvailabilityChecker;
import tp3.model.reservation.CottageType;
import tp3.model.reservation.MockAvailabilityChecker;
import tp3.model.reservation.Reservation;
import tp3.model.reservation.ReservationBuilder;
import tp3.model.reservation.customer.Customer;
import tp3.model.reservation.receipt.Receipt;
import tp3.model.reservation.receipt.ReceiptBuilder;
import tp3.model.reservation.repository.ReceiptRepository;
import tp3.view.DTO.DTOActivities;




import tp3.view.DTO.DTOBaseInfo;
import tp3.view.DTO.DTOContactInfo;
import tp3.view.DTO.DTOReceiptActivityItem;
import tp3.view.DTO.DTOReceiptContactInfo;
import tp3.view.DTO.DTOSelectedDate;
import tp3.view.reservation.ReservationActivitiesView;
import tp3.view.reservation.ReservationBaseInfoView;
import tp3.view.reservation.ReservationMainView;
import tp3.view.reservation.ReservationReceiptView;
import tp3.view.reservation.ReservationVerificationView;
import tp3.view.reservation.ReservationView;

public class ReservationController {
	
	private ReceiptRepository repository;
	private ReservationBuilder reservationBuilder;
	private ReservationMainView reservationMainView;

	

	private ReservationView currentPanel;
	
	// Pour la vérification de disponibilité
	private int numberOfDays;
	private CottageType cottageType;
	
	// Pour création et affichage de la facture
	private Reservation reservation;
	
	private DTOSelectedDate selectedDateDTO;
	private int numberOfCustomers;
	
	private Receipt receipt;
	private ReceiptBuilder receiptBuilder;
	private ArrayList<DTOReceiptContactInfo> contactInfoList;
	private ArrayList<DTOReceiptActivityItem> activityList;
	private DTOActivities activitiesInfo;
	private DTOBaseInfo baseInfo;
	
	public ReservationController(ReceiptRepository repository){
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
		
		this.baseInfo = baseInfo;
		
		this.numberOfDays = baseInfo.numberOfNights;
		this.cottageType = baseInfo.cottageType;
		this.numberOfCustomers = baseInfo.numberOfPeople;
		
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
		
		this.activitiesInfo = activitiesInfo;
		
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
		Customer customer = new Customer(contactInfoDTO.name, contactInfoDTO.address, contactInfoDTO.phone, contactInfoDTO.email);
		Reservation reservation = this.reservation;
		DTOSelectedDate selectedDate = this.selectedDateDTO;
		
		this.receipt = new Receipt(customer, reservation, selectedDate);
		setupReceipt(this.baseInfo, this.activitiesInfo, this.receipt, this.numberOfCustomers, this.numberOfDays);
		
		this.reservationMainView.removeNextButton();
		ReservationView receiptView = new ReservationReceiptView(this.activityList, this.contactInfoList);
		
		this.reservationMainView.setPanel(receiptView);
		this.currentPanel = receiptView;
	}

	private void setupReceipt(DTOBaseInfo baseInfo, DTOActivities activities, Receipt receipt, int nbOfCustomers, int nbOfDays) {
		
		this.receiptBuilder = new ReceiptBuilder(baseInfo, activities, receipt, nbOfDays, nbOfCustomers);
		this.repository.add(receiptBuilder);
		this.receiptBuilder.build();
		this.contactInfoList = this.receiptBuilder.getReceiptContactInfo();			
		this.activityList = this.receiptBuilder.getReceiptActivityList();
	}


	
}