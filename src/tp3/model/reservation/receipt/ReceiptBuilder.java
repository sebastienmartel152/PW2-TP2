package tp3.model.reservation.receipt;

import java.util.ArrayList;
import java.util.Collection;

import tp3.model.cottage.FourPersonCottage;
import tp3.model.cottage.SixPersonCottage;
import tp3.model.cottage.TenPersonCottage;
import tp3.model.option.activity.BlackBearObservationActivity;
import tp3.model.option.activity.FishingActivity;
import tp3.model.option.activity.WolfObservationActivity;
import tp3.model.option.meal.MealBreakfastDinner;
import tp3.model.option.meal.MealGastronomicSupper;
import tp3.model.option.transport.TransportBoat;
import tp3.model.option.transport.TransportHydroplane;
import tp3.model.reservation.CottageType;
import tp3.model.reservation.Reservation;
import tp3.model.reservation.TransportType;
import tp3.model.reservation.customer.Customer;
import tp3.view.DTO.DTOActivities;
import tp3.view.DTO.DTOBaseInfo;
import tp3.view.DTO.DTOContactInfo;
import tp3.view.DTO.DTOReceiptActivityItem;
import tp3.view.DTO.DTOReceiptContactInfo;

public class ReceiptBuilder {
	
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
		this.contactInfo.add(new DTOReceiptContactInfo("Nom", customer.getName()));
		this.contactInfo.add(new DTOReceiptContactInfo("Adresse", customer.getAddress()));
		this.contactInfo.add(new DTOReceiptContactInfo("Téléphone", customer.getPhone()));
		this.contactInfo.add(new DTOReceiptContactInfo("Email", customer.getMail()));	
	}
	
	
	public void setUpReceipt(){
		Reservation reservation = this.receipt.getReservation();
		
		if(this.baseInfo.cottageType == CottageType.FOURPERSON){
			this.listItems.add(new DTOReceiptActivityItem("Chalet 4 personnes", (150.00 * this.nbOfDays)));
		}
		
		if(this.baseInfo.cottageType == CottageType.SIXPERSON){
			this.listItems.add(new DTOReceiptActivityItem("Chalet 6 personnes", (200.00 * this.nbOfDays)));
		}
		
		if(this.baseInfo.cottageType == CottageType.TENPERSON){
			this.listItems.add(new DTOReceiptActivityItem("Chalet 10 personnes", (300.00 * this.nbOfDays)));
		}
		
		if(this.baseInfo.transportTo == TransportType.BOAT){
			this.listItems.add(new DTOReceiptActivityItem("Transport par bateau", (30.00 * this.nbOfCustomers)));	
		}else{
			this.listItems.add(new DTOReceiptActivityItem("Transport par hydroplane", (150.00 * this.nbOfCustomers)));
		}
		
		if(this.baseInfo.transportBack == TransportType.BOAT){
			this.listItems.add(new DTOReceiptActivityItem("Transport par bateau", (30.00 * this.nbOfCustomers)));	
		}else{
			this.listItems.add(new DTOReceiptActivityItem("Transport par hydroplane", (150.00 * this.nbOfCustomers)));
		}
		
		if(this.baseInfo.breakfastDinnerOption){
			this.listItems.add(new DTOReceiptActivityItem("Option déjeuner-diner", (10.00 * this.nbOfCustomers * nbOfDays)));
		}
		
		if(this.baseInfo.gastronomicSupperOption){
			this.listItems.add(new DTOReceiptActivityItem("Option souper gastronomique", (40.00 * this.nbOfCustomers * nbOfDays)));
		}else{
			this.listItems.add(new DTOReceiptActivityItem("Option souper régulier", (18.00 * this.nbOfCustomers * this.nbOfCustomers)));
		}
		
		if(this.activities.blackBearObservation){
			this.listItems.add(new DTOReceiptActivityItem("Observation des ours", (15.00 * this.nbOfCustomers)));
		}
				
		if(this.activities.flyFishing){
			this.listItems.add(new DTOReceiptActivityItem("Activité de pêche", (15.00 * this.nbOfCustomers)));
		}
		
		if(this.activities.wolfObservation){
			this.listItems.add(new DTOReceiptActivityItem("Observation des loups", (15.00 * this.nbOfCustomers)));
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

}

