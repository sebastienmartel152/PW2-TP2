package tp3.model.option.activity;

import tp3.model.option.activity.ActivityOption;
import tp3.model.reservation.Reservation;

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
