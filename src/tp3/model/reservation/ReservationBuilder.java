package tp3.model.reservation;

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

public class ReservationBuilder {
	
	private Reservation reservation;
	private int numberOfPeople;
	private int numberOfDays;
	
	public ReservationBuilder(CottageType cottageType, int numberOfPeople, int numberOfDays, TransportType transportTo, TransportType transportBack){
		this.numberOfDays = numberOfDays;
		this.numberOfPeople = numberOfPeople;
		
		setBaseCottage(cottageType);
		addTransport(transportTo);
		addTransport(transportBack);
		
		addSupper();
	
	}
	
	private void setBaseCottage(CottageType cottageType){
		switch(cottageType){
		case FOURPERSON:
			reservation = new FourPersonCottage(this.numberOfPeople, this.numberOfDays);
			break;
		case SIXPERSON:
			reservation = new SixPersonCottage(this.numberOfPeople, this.numberOfDays);
			break;
		case TENPERSON:
			reservation = new TenPersonCottage(this.numberOfPeople, this.numberOfDays);
			break;
		default:
			break;
		}
	}
	
	private void addTransport(TransportType transportFrom) {
		switch(transportFrom){
		case BOAT:
			reservation = new TransportBoat(reservation, this.numberOfPeople);
			break;
		case HYDROPLANE:
			reservation = new TransportHydroplane(reservation, this.numberOfPeople);
			break;
		default:
			break;
		
		}
	}
	
	private void addSupper(){
		reservation = new MealSupper(reservation, this.numberOfPeople, this.numberOfDays);
	}
	
	// Repas
	
	public ReservationBuilder withBreakfastDinner(){
		reservation = new MealBreakfastDinner(reservation, this.numberOfPeople, this.numberOfDays);
		
		return this;
	}
	
	public ReservationBuilder withGastronomicSupper(){
		reservation = new MealGastronomicSupper(reservation, this.numberOfPeople, this.numberOfDays);
		
		return this;
	}
		
	// Activités
	
	public ReservationBuilder withBlackBearObservationActivity(){
		reservation = new BlackBearObservationActivity(reservation, this.numberOfPeople);
		
		return this;
	}
	
	public ReservationBuilder withFishingActivity(){
		reservation = new FishingActivity(reservation, this.numberOfPeople);
		
		return this;
	}
	
	public ReservationBuilder withWolfObservationActivity(){
		reservation = new WolfObservationActivity(reservation, this.numberOfPeople);
		
		return this;
	}
	
	// Build
	
	public Reservation build(){
		return reservation;
	}
	

}
