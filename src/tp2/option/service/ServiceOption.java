package tp2.option.service;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public abstract class ServiceOption extends ReservationOption {
	
	private static final int MINIMUM_NB_OF_PEOPLE = 1;
	private int numberOfDays;
	
	public ServiceOption(Reservation reservation, int numberOfDays) {
		super(reservation);
		validateNumberDays(numberOfDays);
		this.numberOfDays = numberOfDays;
	}
	
	public int getNumberOfDays(){
		return this.numberOfDays;
	}
	
	private void validateNumberDays(int numberOfDays){
		if(numberOfDays < MINIMUM_NB_OF_PEOPLE){
			throw new NumberOfDaysMustBeGreaterThan0();
		}
	}
}
