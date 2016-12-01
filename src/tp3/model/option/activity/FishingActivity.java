package tp3.model.option.activity;

import tp3.model.reservation.Reservation;

public class FishingActivity extends ActivityOption {
	
	public static final double DEFAULT_COST = 15;
	private static double unitCostPerPerson = DEFAULT_COST;
	
	public FishingActivity(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}
	
	@Override
	public double getOptionCost(){
		return FishingActivity.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double newCost){
		FishingActivity.unitCostPerPerson = newCost;
	}
	
	public static double getUnitCost(){
		return FishingActivity.unitCostPerPerson;
	}
	
}
