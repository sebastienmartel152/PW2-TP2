package tp2.option.activity;

import tp2.reservation.Reservation;

public class TrappingActivity extends ActivityOption {
	
	public static final double DEFAULT_COST = 12;
	private static double unitCostPerPerson = DEFAULT_COST;
	
	public TrappingActivity(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}
	
	public double getUnitCost(){
		return TrappingActivity.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double newCost){
		TrappingActivity.unitCostPerPerson = newCost;
	}
	
}
