package tp3.model.option.activity;

import tp3.model.reservation.Reservation;

public class BlackBearObservationActivity extends ActivityOption {
	
	public static final double DEFAULT_COST = 15;
	private static double unitCostPerPerson = DEFAULT_COST;
	
	public BlackBearObservationActivity(Reservation reservation, int numberOfPeople) {
		super(reservation, numberOfPeople);
	}
	
	@Override
	public double getOptionCost(){
		return BlackBearObservationActivity.unitCostPerPerson * super.getNumberOfPeople();
	}
	
	public static void setUnitCost(double newCost){
		BlackBearObservationActivity.unitCostPerPerson = newCost;
	}
	
	public static double getUnitCost(){
		return BlackBearObservationActivity.unitCostPerPerson;
	}
}
