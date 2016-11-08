package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealGastronomicSupper extends MealOption {
	public final static double DEFAULT_COST_PER_PERSON_PER_DAY = 22;
	private static double unitCostPerPersonPerDay = DEFAULT_COST_PER_PERSON_PER_DAY;
	
	public MealGastronomicSupper(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation, numberOfPeople, numberOfDays);
	}

	@Override
	public double getUnitCost() {
		return MealGastronomicSupper.unitCostPerPersonPerDay * super.getNumberOfPeople() * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double cost){
		MealGastronomicSupper.unitCostPerPersonPerDay = cost;
	}

}
