package tp2.option.meal;

import tp2.reservation.Reservation;

public class MealOptionMock extends MealOption{
	public static final double ANY_COST_PER_DAY_PER_PERSON = 10;
	
	public MealOptionMock(Reservation reservation, int numberOfPeople, int numberOfDays) {
		super(reservation, numberOfPeople, numberOfDays);
	}

	@Override
	public double getUnitCost() {
		return MealOptionMock.ANY_COST_PER_DAY_PER_PERSON * super.getNumberOfDays() * super.getNumberOfPeople();
	}

}
