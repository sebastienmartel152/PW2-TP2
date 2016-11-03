package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealSupper extends MealOption {
	public final static double DEFAULT_COST_PER_PERSON = 18;
	private static double unitCostPerPerson = DEFAULT_COST_PER_PERSON;
	
	public MealSupper(Reservation reservation, int nbPeople) {
		super(reservation, nbPeople);
	}

	@Override
	public double getUnitCost() {
		return MealSupper.unitCostPerPerson * super.getNbPeople();
	}
	
	public static void setUnitCost(double cost){
		MealSupper.unitCostPerPerson = cost;
	}

}
