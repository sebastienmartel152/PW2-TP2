 package tp3.model.option.transport;

import tp3.model.option.ReservationOption;
import tp3.model.reservation.Reservation;

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
