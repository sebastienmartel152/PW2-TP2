package tp2.option.transport;

import tp2.reservation.Reservation;

public class TransportOptionMock extends TransportOption {
	public static final double ANY_COST = 15;
	
	public TransportOptionMock(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}

	@Override
	public double getUnitCost() {
		return ANY_COST * super.getNumberOfPeople();
	}

}
