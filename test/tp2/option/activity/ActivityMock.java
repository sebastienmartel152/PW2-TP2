package tp2.option.activity;

import tp2.reservation.Reservation;

public class ActivityMock extends ActivityOption {
	

	public static final double ANY_COST_PER_PERSON = 100;

	public ActivityMock(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}

	@Override
	public double getUnitCost() {
		return ActivityMock.ANY_COST_PER_PERSON * super.getNumberOfPeople();
	}
	
	

}
