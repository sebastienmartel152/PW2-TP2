package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealBreakfastDinner extends MealOption {
	public final static double DEFAULT_COST_PER_PERSON_PER_DAY = 10;
	private static double unitCostPerPersonPerDay = DEFAULT_COST_PER_PERSON_PER_DAY;
	
	public MealBreakfastDinner(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation, numberOfPeople, numberOfDays);
	}

	@Override
	public double getUnitCost() {
		return MealBreakfastDinner.unitCostPerPersonPerDay * super.getNumberOfPeople() * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double cost){
		MealBreakfastDinner.unitCostPerPersonPerDay = cost;
	}

}
