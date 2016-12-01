package tp3.model.option.meal;

import tp3.model.option.meal.MealOption;
import tp3.model.reservation.Reservation;

public class MealOptionMock extends MealOption {
	public final static double ANY_COST = 15;
	
	public MealOptionMock(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation, numberOfPeople, numberOfDays);
	}

	@Override
	public double getOptionCost() {
		return ANY_COST;
	}
	
}
