package tp3.model.option.meal;

import tp3.model.reservation.Reservation;

public class MealGastronomicSupper extends MealOption {
	public final static double DEFAULT_COST_PER_PERSON_PER_SUPPER = 22;
	private static double unitCostPerPersonPerSupper = DEFAULT_COST_PER_PERSON_PER_SUPPER;
	
	
	public MealGastronomicSupper(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation, numberOfPeople, numberOfDays);
	}

	@Override
	public double getOptionCost() {
		return MealGastronomicSupper.unitCostPerPersonPerSupper * super.getNumberOfPeople() * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double newCost){
		MealGastronomicSupper.unitCostPerPersonPerSupper = newCost;
	}
	
	public static double getUnitCost(){
		return MealGastronomicSupper.unitCostPerPersonPerSupper;
	}

}
