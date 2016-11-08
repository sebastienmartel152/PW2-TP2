package tp2.option.service;

import tp2.reservation.Reservation;

public class ElectricMotorService extends ServiceOption{
	public static final double DEFAULT_COST_PER_DAY = 30;
	private static double unitCostPerDay = DEFAULT_COST_PER_DAY;
	
	public ElectricMotorService(Reservation reservation, int numberOfDays) {
		super(reservation, numberOfDays);
	}

	@Override
	public double getUnitCost() {
		return ElectricMotorService.unitCostPerDay * super.getNumberOfDays();
	}
	
	public static void setUnitCost(double cost){
		ElectricMotorService.unitCostPerDay = cost;
	}
}
