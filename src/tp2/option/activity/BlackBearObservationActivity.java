package tp2.option.activity;

import tp2.reservation.Reservation;

public class BlackBearObservationActivity extends ActivityOption {
	
	public static final double DEFAULT_COST = 15;
	private static double unitCostPerPerson = DEFAULT_COST;
	
	public BlackBearObservationActivity(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}
	
	@Override
	public double getUnitCost(){  //@SM: revoir le nom. pas vraiement le unitCost
		return BlackBearObservationActivity.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double newCost){
		BlackBearObservationActivity.unitCostPerPerson = newCost;
	}
	
}
