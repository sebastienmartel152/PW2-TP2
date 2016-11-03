package tp2.option.transport;

import tp2.reservation.Reservation;

public class TransportBoat extends TransportOption {
	public static final double DEFAULT_COST_PER_PERSON = 30.0;
	private static double unitCostPerPerson = DEFAULT_COST_PER_PERSON;
	
	private int nbPeople;
	
	public TransportBoat(Reservation reservation, int nbPeople) {
		super(reservation);
		
		this.nbPeople = nbPeople;
	}

	@Override
	public double getUnitCost() {
		return TransportBoat.unitCostPerPerson * this.nbPeople;
	}
	
	public static void setUnitCost(double cost){
		TransportBoat.unitCostPerPerson = cost;
	}

}
