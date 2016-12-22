package tp3.model.option.activity;

import tp3.model.reservation.Reservation;

public class WolfObservationActivity extends ActivityOption {
	
	public static final double DEFAULT_COST = 15;
	private static double unitCostPerPerson = DEFAULT_COST;
	
	public WolfObservationActivity(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}
	
	@Override
	public double getOptionCost(){  //@SM: refactoring du TP2
		return WolfObservationActivity.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double newCost){
		WolfObservationActivity.unitCostPerPerson = newCost;
	}
	
	public static double getUnitCost(){
		return WolfObservationActivity.unitCostPerPerson;
	}
	
}
