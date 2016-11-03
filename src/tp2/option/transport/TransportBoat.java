package tp2.option.transport;

import tp2.reservation.Reservation;

public class TransportBoat extends TransportOption {
	public static final double DEFAULT_COST_PER_PERSON = 30.0;
	private static double unitCost = DEFAULT_COST_PER_PERSON;
	
	public TransportBoat(Reservation reservation) {
		super(reservation);
	}

	@Override
	public double getUnitCost() {
		return TransportBoat.unitCost;
	}
	

}
