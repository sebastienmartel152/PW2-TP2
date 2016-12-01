package tp2.option.transport;

import tp3.model.option.transport.TransportOption;
import tp3.model.reservation.Reservation;

public class TransportOptionMock extends TransportOption {
	public static final double ANY_COST = 15;
	
	public TransportOptionMock(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}

	@Override
	public double getOptionCost() {
		return ANY_COST;
	}

}
