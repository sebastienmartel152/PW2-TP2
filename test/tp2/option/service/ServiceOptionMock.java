package tp2.option.service;

import tp2.reservation.Reservation;

public class ServiceOptionMock extends ServiceOption {
	public static final double ANY_COST_PER_DAY = 100;
	
	public ServiceOptionMock(Reservation reservation, int numberOfDays) {
		super(reservation, numberOfDays);
	}

	@Override
	public double getUnitCost() {
		return ServiceOptionMock.ANY_COST_PER_DAY * super.getNumberOfDays();
	}
}
