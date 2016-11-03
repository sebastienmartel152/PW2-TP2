package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealGastronomicSupper extends MealOption {
	public final static double DEFAULT_COST_PER_PERSON = 22;
	private static double unitCostPerPerson = DEFAULT_COST_PER_PERSON;
	
	private int nbPeople;
	
	public MealGastronomicSupper(Reservation reservation, int nbPeople) {
		super(reservation);
		this.nbPeople = nbPeople;
	}

	@Override
	public double getUnitCost() {
		return MealGastronomicSupper.unitCostPerPerson * this.nbPeople;
	}
	
	public static void setUnitCost(double cost){
		MealGastronomicSupper.unitCostPerPerson = cost;
	}

}
