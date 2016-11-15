package tp2.reservation;

import tp2.cottage.FourPersonCottage;
import tp2.cottage.SixPersonCottage;
import tp2.cottage.TenPersonCottage;
import tp2.option.activity.BaitBuildingActivity;
import tp2.option.activity.BeaverObservationActivity;
import tp2.option.activity.BlackBearObservationActivity;
import tp2.option.activity.FishSmokingActivity;
import tp2.option.activity.FishingActivity;
import tp2.option.activity.GuidedHuntingActivity;
import tp2.option.activity.TrappingActivity;
import tp2.option.activity.WolfObservationActivity;
import tp2.option.meal.MealBreakfastDinner;
import tp2.option.meal.MealGastronomicSupper;
import tp2.option.meal.MealSupper;
import tp2.option.service.ATVService;
import tp2.option.service.CleaningService;
import tp2.option.service.ElectricMotorService;
import tp2.option.service.ExtraBoatService;
import tp2.option.transport.TransportBoat;
import tp2.option.transport.TransportHydroplane;

public class ReservationBuilder {
	
	private Reservation reservation;
	
	public ReservationBuilder(CottageType cottageType, int numberOfPeople, int numberOfDays, TransportType transportTo, TransportType transportFrom){
		setBaseCottage(cottageType, numberOfPeople);
		addTransport(transportTo, numberOfPeople);
		addTransport(transportFrom, numberOfPeople);
		
		addSupper(numberOfPeople, numberOfDays);
	}
	
	public ReservationBuilder(Deal deal, int numberOfPeople, int numberOfDays){
		
	}
	
	private void setBaseCottage(CottageType cottageType, int numberOfPeople){
		switch(cottageType){
		case FOURPERSON:
			reservation = new FourPersonCottage(numberOfPeople);
			break;
		case SIXPERSON:
			reservation = new SixPersonCottage(numberOfPeople);
			break;
		case TENPERSON:
			reservation = new TenPersonCottage(numberOfPeople);
			break;
		default:
			break;
		}
	}
	
	private void addTransport(TransportType transportFrom, int numberOfPeople) {
		switch(transportFrom){
		case BOAT:
			reservation = new TransportBoat(reservation, numberOfPeople);
			break;
		case HYDROPLANE:
			reservation = new TransportHydroplane(reservation, numberOfPeople);
			break;
		default:
			break;
		
		}
	}
	
	private void addSupper(int numberOfPeople, int numberOfDays){
		reservation = new MealSupper(reservation, numberOfPeople, numberOfDays);
	}
	
	public ReservationBuilder withBreakfastDinner(int numberOfPeople, int numberOfDays){
		reservation = new MealBreakfastDinner(reservation, numberOfPeople, numberOfDays);
		
		return this;
	}
	
	public ReservationBuilder withGastronomicSupper(int numberOfPeople, int numberOfDays){
		reservation = new MealGastronomicSupper(reservation, numberOfPeople, numberOfDays);
		
		return this;
	}
	
	
	public ReservationBuilder withCleaningService(int numberOfDays){
		reservation = new CleaningService(reservation, numberOfDays);
		
		return this;
	}
	
	public ReservationBuilder withATVService(int numberOfDays){
		reservation = new ATVService(reservation, numberOfDays);
		
		return this;
	}
	
	public ReservationBuilder withElectricMotorService(int numberOfDays){
		reservation = new ElectricMotorService(reservation, numberOfDays);
		
		return this;
	}
	
	public ReservationBuilder withExtraBoatService(int numberOfDays){
		reservation = new ExtraBoatService(reservation, numberOfDays);
	
		return this;
	}
	
	public ReservationBuilder withBaitBuildingActivity(int numberOfPeople){
		reservation = new BaitBuildingActivity(reservation, numberOfPeople);
		
		return this;
	}
	
	public ReservationBuilder withBeaverObservationActivity(int numberOfPeople){
		reservation = new BeaverObservationActivity(reservation, numberOfPeople);
		
		return this;
	}
	
	public ReservationBuilder withBlackBearObservationActivity(int numberOfPeople){
		reservation = new BlackBearObservationActivity(reservation, numberOfPeople);
		
		return this;
	}
	
	public ReservationBuilder withFishingActivity(int numberOfPeople){
		reservation = new FishingActivity(reservation, numberOfPeople);
		
		return this;
	}
	
	public ReservationBuilder withFishSmokingActivity(int numberOfPeople){
		reservation = new FishSmokingActivity(reservation, numberOfPeople);
		
		return this;
	}
	
	public ReservationBuilder withGuidedHuntingActivity(int numberOfPeople){
		reservation = new GuidedHuntingActivity(reservation, numberOfPeople);
		
		return this;
	}
	
	public ReservationBuilder withTrappingActivity(int numberOfPeople){
		reservation = new TrappingActivity(reservation, numberOfPeople);
		
		return this;
	}
	
	public ReservationBuilder withWolfObservationActivity(int numberOfPeople){
		reservation = new WolfObservationActivity(reservation, numberOfPeople);
		
		return this;
	}
	
	public Reservation build(){
		return reservation;
	}
}
