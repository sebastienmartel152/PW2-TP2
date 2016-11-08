package tp2.option.activity;

import tp2.reservation.Reservation;

public class BeaverObservationActivity extends ActivityOption {
	
	public static final double DEFAULT_COST = 8;
	private static double unitCostPerPerson = DEFAULT_COST;
	
	public BeaverObservationActivity(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}
	
	public double getUnitCost(){
		return BeaverObservationActivity.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double newCost){
		BeaverObservationActivity.unitCostPerPerson = newCost;
	}
	
}
