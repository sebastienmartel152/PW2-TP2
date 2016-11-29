package tp2.option.activity;

import tp2.reservation.Reservation;

public class WolfObservationActivity extends ActivityOption {
	
	public static final double DEFAULT_COST = 15;
	private static double unitCostPerPerson = DEFAULT_COST;
	
	public WolfObservationActivity(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}
	
	@Override
	public double getOptionCost(){
		return WolfObservationActivity.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double newCost){
		WolfObservationActivity.unitCostPerPerson = newCost;
	}
	
	public static double getUnitCost(){
		return WolfObservationActivity.unitCostPerPerson;
	}
	
}
