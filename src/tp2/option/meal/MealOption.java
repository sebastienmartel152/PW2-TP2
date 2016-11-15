package tp2.option.meal;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public abstract class MealOption extends ReservationOption{
	
	private int numberOfPeople;
	private int numberOfDays;
	
	public MealOption(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation);
		this.numberOfPeople = numberOfPeople;
		this.numberOfDays = numberOfDays;
	}
	
	public int getNumberOfPeople(){
		return this.numberOfPeople;
	}
	
	public int getNumberOfDays(){
		return this.numberOfDays;
	}

}
