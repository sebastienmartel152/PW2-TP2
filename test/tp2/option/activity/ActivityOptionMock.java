package tp2.option.activity;

import tp2.reservation.Reservation;

public class ActivityOptionMock extends ActivityOption {
	

	public static final double ANY_COST = 100;

	public ActivityOptionMock(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}

	@Override
	public double getOptionCost() {
		return ActivityOptionMock.ANY_COST;
	}
	
	

}
