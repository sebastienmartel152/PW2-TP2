package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealBreakfastDinner extends MealOption {
	public final static double DEFAULT_COST_PER_PERSON_PER_BREAKFAST = 10;
	private static double unitCostPerPersonPerBreakfast = DEFAULT_COST_PER_PERSON_PER_BREAKFAST;

	public MealBreakfastDinner(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation, numberOfPeople, numberOfDays);
	}

	@Override
	public double getOptionCost() {
		return MealBreakfastDinner.unitCostPerPersonPerBreakfast * super.getNumberOfPeople() * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double newCost){
		MealBreakfastDinner.unitCostPerPersonPerBreakfast = newCost;
	}
	
	public static double getUnitCost(){
		return MealBreakfastDinner.unitCostPerPersonPerBreakfast;
	}

}
