package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealSupper extends MealOption {
	public final static double DEFAULT_COST_PER_PERSON_PER_DAY = 18;
	private static double unitCostPerPersonPerDay = DEFAULT_COST_PER_PERSON_PER_DAY;
	
	public MealSupper(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation, numberOfPeople, numberOfDays);
	}

	@Override
	public double getUnitCost() {
		return MealSupper.unitCostPerPersonPerDay * super.getNumberOfPeople() * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double cost){
		MealSupper.unitCostPerPersonPerDay = cost;
	}

}
