package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealOptionMock extends MealOption {
	public final static double ANY_COST_PER_MEAL_PER_PERSON = 15;
	private static double unitCostPerPersonPerMeal = ANY_COST_PER_MEAL_PER_PERSON;
	
	
	public MealOptionMock(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation, numberOfPeople, numberOfDays);
	}

	@Override 
	public double getUnitCost() {  //@SM: même remarque pour tous les mocks: pas de comportement...
		return MealOptionMock.unitCostPerPersonPerMeal * super.getNumberOfPeople() * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double newCost){
		MealOptionMock.unitCostPerPersonPerMeal = newCost;
	}
}
