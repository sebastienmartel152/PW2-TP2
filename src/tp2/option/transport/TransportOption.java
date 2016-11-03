package tp2.option.transport;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public abstract class TransportOption extends ReservationOption {

	public TransportOption(Reservation reservation) {
		super(reservation);
	}
	
}
