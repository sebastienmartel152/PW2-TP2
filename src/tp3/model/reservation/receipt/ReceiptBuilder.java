package tp3.model.reservation.receipt;

import java.util.ArrayList;

import tp3.model.cottage.FourPersonCottage;
import tp3.model.cottage.SixPersonCottage;
import tp3.model.cottage.TenPersonCottage;
import tp3.model.option.activity.BlackBearObservationActivity;
import tp3.model.option.activity.FishingActivity;
import tp3.model.option.activity.WolfObservationActivity;
import tp3.model.option.meal.MealBreakfastDinner;
import tp3.model.option.meal.MealGastronomicSupper;
import tp3.model.option.meal.MealSupper;
import tp3.model.option.transport.TransportBoat;
import tp3.model.option.transport.TransportHydroplane;
import tp3.model.reservation.CottageType;
import tp3.model.reservation.TransportType;
import tp3.model.reservation.customer.Customer;
import tp3.view.DTO.DTOActivities;
import tp3.view.DTO.DTOBaseInfo;
import tp3.view.DTO.DTOReceiptActivityItem;
import tp3.view.DTO.DTOReceiptContactInfo;
import tp3.view.DTO.DTOSelectedDate;

public class ReceiptBuilder {  //@SM: il y a un mélange ici entre le modèle et le DTO --> à revoir
								//@SM: revoir pour la facturation. Vous refaites le travail et les calculs!! C'est affreux, c'est de la redondance! Et en évidemment, avec une erreur.
								//@SM: n'est relié à aucune réservation, ni n'utilise aucune réservation...
	
	//@SM: que de responsabilités pour une seule classe!
	
	private static final String WOLF_OBSERVATION_TEXT = "Observation des loups";  //@SM: c'est du texte déjà affiché dans l'interface
																					//@SM: pourquoi ne pas avoir utilisé les énums?
	private static final String FISHING_TEXT = "Activité de pêche";
	private static final String BEAR_OBSERVATION_TEXT = "Observation des ours";
	private static final String REGULAR_SUPPER_TEXT = "Option souper régulier";
	private static final String FANCY_SUPPER_TEXT = "Option souper gastronomique";
	private static final String BREAKFAST_DINNER_TEXT = "Option déjeuner-diner";
	private static final String TRANSPORT_HYDROPLANE_TEXT = "Transport par hydroplane";
	private static final String TRANSPORT_BOAT_TEXT = "Transport par bateau";
	private static final String TENPERSON_COTTAGE_TEXT = "Chalet 10 personnes";
	private static final String SIXPERSON_COTTAGE_TEXT = "Chalet 6 personnes";
	private static final String FOURPERSON_COTTAGE_TEXT = "Chalet 4 personnes";
	private static final String MAIL_LABEL = "Email";
	private static final String PHONE_LABEL = "Téléphone";
	private static final String ADDRESS_LABEL = "Adresse";
	private static final String NAME_LABEL = "Nom";
	private Receipt receipt;
	private int nbOfDays;
	private int nbOfCustomers;
	
	private ArrayList<DTOReceiptActivityItem> listItems = new ArrayList<DTOReceiptActivityItem>();
	private ArrayList<DTOReceiptContactInfo> contactInfo = new ArrayList<DTOReceiptContactInfo>();
	private DTOBaseInfo baseInfo;
	private DTOActivities activities;
	
	
	
	public ReceiptBuilder(DTOBaseInfo baseInfo, DTOActivities activities, Receipt receipt, int nbOfDays, int nbOfCustomers){
		this.baseInfo = baseInfo;
		this.activities = activities;
		this.receipt = receipt;
		this.nbOfDays = nbOfDays;
		this.nbOfCustomers = nbOfCustomers;
	}

	public void setUpCustomer(){
		
		Customer customer = this.receipt.getCustomer();
		this.contactInfo.add(new DTOReceiptContactInfo(NAME_LABEL, customer.getName()));
		this.contactInfo.add(new DTOReceiptContactInfo(ADDRESS_LABEL, customer.getAddress()));
		this.contactInfo.add(new DTOReceiptContactInfo(PHONE_LABEL, customer.getPhone()));
		this.contactInfo.add(new DTOReceiptContactInfo(MAIL_LABEL, customer.getMail()));	
	}
	
	
	public void setUpReceipt(){  //@SM: quelle erreur ici!! Vous utilisez les DEFAUTL_PRICE (qui d'ailleurs être privées dans leurs classes au lieu de unitCostPerPersonPerSupper!!
		
		if(this.baseInfo.cottageType == CottageType.FOURPERSON){
			this.listItems.add(new DTOReceiptActivityItem(FOURPERSON_COTTAGE_TEXT, (FourPersonCottage.DEFAULT_COTTAGE_PRICE * this.nbOfDays)));
		}
		
		if(this.baseInfo.cottageType == CottageType.SIXPERSON){
			this.listItems.add(new DTOReceiptActivityItem(SIXPERSON_COTTAGE_TEXT, (SixPersonCottage.DEFAULT_COTTAGE_PRICE * this.nbOfDays)));
		}
		
		if(this.baseInfo.cottageType == CottageType.TENPERSON){
			this.listItems.add(new DTOReceiptActivityItem(TENPERSON_COTTAGE_TEXT, (TenPersonCottage.DEFAULT_COTTAGE_PRICE * this.nbOfDays)));
		}
		
		if(this.baseInfo.transportTo == TransportType.BOAT){
			this.listItems.add(new DTOReceiptActivityItem(TRANSPORT_BOAT_TEXT, (TransportBoat.DEFAULT_COST_PER_PERSON * this.nbOfCustomers)));	
		}else{
			this.listItems.add(new DTOReceiptActivityItem(TRANSPORT_HYDROPLANE_TEXT, (TransportHydroplane.DEFAULT_COST_PER_PERSON * this.nbOfCustomers)));
		}
		
		if(this.baseInfo.transportBack == TransportType.BOAT){
			this.listItems.add(new DTOReceiptActivityItem(TRANSPORT_BOAT_TEXT, (TransportBoat.DEFAULT_COST_PER_PERSON * this.nbOfCustomers)));	
		}else{
			this.listItems.add(new DTOReceiptActivityItem(TRANSPORT_HYDROPLANE_TEXT, (TransportHydroplane.DEFAULT_COST_PER_PERSON * this.nbOfCustomers)));
		}
		
		if(this.baseInfo.breakfastDinnerOption){
			this.listItems.add(new DTOReceiptActivityItem(BREAKFAST_DINNER_TEXT, (MealBreakfastDinner.DEFAULT_COST_PER_PERSON_PER_BREAKFAST * this.nbOfCustomers * nbOfDays)));
		}
		
		if(this.baseInfo.gastronomicSupperOption){
			this.listItems.add(new DTOReceiptActivityItem(FANCY_SUPPER_TEXT, ((MealGastronomicSupper.DEFAULT_COST_PER_PERSON_PER_SUPPER + MealSupper.DEFAULT_COST_PER_PERSON_PER_SUPPER) * this.nbOfCustomers * nbOfDays)));
		}else{
			this.listItems.add(new DTOReceiptActivityItem(REGULAR_SUPPER_TEXT, (MealSupper.DEFAULT_COST_PER_PERSON_PER_SUPPER * this.nbOfCustomers * this.nbOfCustomers)));  //@SM: oh! devrait mutiplier par le nombre de jours
		}
		
		if(this.activities.blackBearObservation){
			this.listItems.add(new DTOReceiptActivityItem(BEAR_OBSERVATION_TEXT, (BlackBearObservationActivity.DEFAULT_COST * this.nbOfCustomers)));
		}
				
		if(this.activities.flyFishing){
			this.listItems.add(new DTOReceiptActivityItem(FISHING_TEXT, (FishingActivity.DEFAULT_COST * this.nbOfCustomers)));
		}
		
		if(this.activities.wolfObservation){
			this.listItems.add(new DTOReceiptActivityItem(WOLF_OBSERVATION_TEXT, (WolfObservationActivity.DEFAULT_COST * this.nbOfCustomers)));
		}
		
		
	}
	
	public ArrayList<DTOReceiptActivityItem> getReceiptActivityList() {
		return this.listItems;
	}
	
	public ArrayList<DTOReceiptContactInfo> getReceiptContactInfo(){
		return this.contactInfo;
	}

	public void build() {
		setUpCustomer();
		setUpReceipt();
	}
	
	public String getName(){
		return this.receipt.getCustomer().getName();
	}
	
	public String getAddress(){
		return this.receipt.getCustomer().getAddress();
	}
	
	public String getPhone(){
		return this.receipt.getCustomer().getPhone();
	}
	
	public String getMail(){
		return this.receipt.getCustomer().getMail();
	}
	
	public String getDate(){
		DTOSelectedDate DTOdate = this.receipt.getDate();
		Integer day = DTOdate.selectedDay;
		Integer month = DTOdate.selectedMonth;
		Integer year = DTOdate.selectedYear;
		String date = day.toString() + "/" + month.toString() + "/" + year.toString();
		return date;
	}
	
	public int getNumberOfDays(){
		return this.baseInfo.numberOfNights;
	}
	
	public double getTotal(){
		return this.receipt.getReservation().calculateTotalCost();
	}
	
	public String getCottageType(){
		String cottageType = "";
		if(this.baseInfo.cottageType == CottageType.FOURPERSON){
			cottageType = FOURPERSON_COTTAGE_TEXT;
		}
		
		if(this.baseInfo.cottageType == CottageType.SIXPERSON){
			cottageType = SIXPERSON_COTTAGE_TEXT;
		}
		
		if(this.baseInfo.cottageType == CottageType.TENPERSON){
			cottageType = TENPERSON_COTTAGE_TEXT;
		}
		return cottageType;
	}

}

