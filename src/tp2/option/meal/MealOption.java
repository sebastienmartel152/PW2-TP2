package tp2.option.meal;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public abstract class MealOption extends ReservationOption{
	private int nbPeople;
	
	public MealOption(Reservation reservation, int nbPeople) {
		super(reservation);
	}
	
	public int getNbPeople(){
		return this.nbPeople;
	}
}
