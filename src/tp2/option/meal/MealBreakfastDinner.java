package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealBreakfastDinner extends MealOption {
	public final static double DEFAULT_COST_PER_PERSON = 10;
	private static double unitCostPerPerson = DEFAULT_COST_PER_PERSON;
	
	public MealBreakfastDinner(Reservation reservation, int nbPeople) {
		super(reservation, nbPeople);
	}

	@Override
	public double getUnitCost() {
		return MealBreakfastDinner.unitCostPerPerson * super.getNbPeople();
	}
	
	public static void setUnitCost(double cost){
		MealBreakfastDinner.unitCostPerPerson = cost;
	}

}
