package tp2.option.transport;

import tp2.reservation.Reservation;

public class TransportHydroplane extends TransportOption {
	public static final double DEFAULT_COST_PER_PERSON = 150.0;
	private static double unitCostPerPerson = DEFAULT_COST_PER_PERSON;
	
	
	public TransportHydroplane(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}

	@Override
	public double getOptionCost() {
		return TransportHydroplane.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double cost){
		TransportHydroplane.unitCostPerPerson = cost;
	}

	public static double getUnitCost(){
		return TransportHydroplane.unitCostPerPerson;
	}
	
}
