package tp2.option.service;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public abstract class ServiceOption extends ReservationOption {
	
	private int numberOfDays;
	
	public ServiceOption(Reservation reservation, int numberOfDays) {
		super(reservation);
		validateNumberDays(numberOfDays);
		this.numberOfDays = numberOfDays;
	}
	
	public int getNumberOfDays(){
		return this.numberOfDays;
	}
	
	private void validateNumberDays(int nbDays){
		if(nbDays < 1){
			throw new NumberOfDaysMustBeGreaterThan0();
		}
	}
}
