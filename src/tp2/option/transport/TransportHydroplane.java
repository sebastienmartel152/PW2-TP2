package tp2.option.transport;

import tp2.reservation.Reservation;

public class TransportHydroplane extends TransportOption {
	public static final double DEFAULT_COST_PER_PERSON = 150.0;
	private static double unitCostPerPerson = DEFAULT_COST_PER_PERSON;
	
	private int nbPeople;
	
	public TransportHydroplane(Reservation reservation, int nbPeople) {
		super(reservation);
		
		this.nbPeople = nbPeople;
	}

	@Override
	public double getUnitCost() {
		return TransportHydroplane.unitCostPerPerson * this.nbPeople;
	}
	
	public static void setUnitCost(double cost){
		TransportHydroplane.unitCostPerPerson = cost;
	}

}
