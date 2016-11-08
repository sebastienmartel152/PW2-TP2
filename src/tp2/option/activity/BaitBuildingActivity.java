package tp2.option.activity;

import tp2.reservation.Reservation;

public class BaitBuildingActivity extends ActivityOption {
	
	public static final double DEFAULT_COST = 10;
	private static double unitCostPerPerson = DEFAULT_COST;
	
	public BaitBuildingActivity(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}
	
	public double getUnitCost(){
		return BaitBuildingActivity.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double newCost){
		BaitBuildingActivity.unitCostPerPerson = newCost;
	}
	
}
