package tp2.option.service;

import tp2.reservation.Reservation;

public class ExtraBoatService extends ServiceOption {
	public static final double DEFAULT_COST_PER_DAY = 8;
	private static double unitCostPerDay = DEFAULT_COST_PER_DAY;
	
	public ExtraBoatService(Reservation reservation, int numberOfDays) {
		super(reservation, numberOfDays);
	}

	@Override
	public double getUnitCost() {
		return ExtraBoatService.unitCostPerDay * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double cost){
		ExtraBoatService.unitCostPerDay = cost;
	}
}
