package tp2.option.transport;

import tp2.reservation.Reservation;

public class TransportBoat extends TransportOption {
	public static final double DEFAULT_COST_PER_PERSON = 30.0;
	private static double unitCostPerPerson = DEFAULT_COST_PER_PERSON;
	
	public TransportBoat(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}

	@Override
	public double getUnitCost() {
		return TransportBoat.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double cost){
		TransportBoat.unitCostPerPerson = cost;
	}

}
