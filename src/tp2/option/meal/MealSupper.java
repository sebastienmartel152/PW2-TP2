package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealSupper extends MealOption {
	public final static double DEFAULT_COST_PER_PERSON_PER_SUPPER = 18;
	private static double unitCostPerPerson = DEFAULT_COST_PER_PERSON_PER_SUPPER;
	

	public MealSupper(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation, numberOfPeople, numberOfDays);
	}

	@Override
	public double getUnitCost() {
		return MealSupper.unitCostPerPerson * super.getNumberOfPeople() * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double newCost){
		MealSupper.unitCostPerPerson = newCost;
	}

}
