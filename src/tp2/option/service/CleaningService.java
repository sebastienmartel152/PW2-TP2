package tp2.option.service;

import tp2.reservation.Reservation;

public class CleaningService extends ServiceOption {
	public static final double DEFAULT_COST_PER_DAY = 8;
	private static double unitCostPerDay = DEFAULT_COST_PER_DAY;
	
	public CleaningService(Reservation reservation, int numberOfDays) {
		super(reservation, numberOfDays);
	}

	@Override
	public double getUnitCost() {
		return CleaningService.unitCostPerDay * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double cost){
		CleaningService.unitCostPerDay = cost;
	}
}
