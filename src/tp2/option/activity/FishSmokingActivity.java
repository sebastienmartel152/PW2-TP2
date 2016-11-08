package tp2.option.activity;

import tp2.reservation.Reservation;

public class FishSmokingActivity extends ActivityOption {
	
	public static final double DEFAULT_COST = 16;
	private static double unitCostPerPerson = DEFAULT_COST;
	
	public FishSmokingActivity(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}
	
	public double getUnitCost(){
		return FishSmokingActivity.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double newCost){
		FishSmokingActivity.unitCostPerPerson = newCost;
	}
	
}
