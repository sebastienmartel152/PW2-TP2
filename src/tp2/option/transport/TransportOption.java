 package tp2.option.transport;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public abstract class TransportOption extends ReservationOption {
	
	private int numberOfPeople;
	
	public TransportOption(Reservation reservation, int numberOfPeople) {
		super(reservation);
		this.numberOfPeople = numberOfPeople;
	}
	
	public int getNumberOfPeople(){
		return this.numberOfPeople;
	}
}
