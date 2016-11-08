package tp2.option.activity;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public class GuidedHuntingActivity extends ReservationOption {
	
	public static final double DEFAULT_COST = 200;
	private static double unitCost = DEFAULT_COST;
	
	public GuidedHuntingActivity(Reservation reservation, int numberOfPeople) {
		super(reservation);
		validateNumberOfPeople(numberOfPeople);
	}
	
	private void validateNumberOfPeople(int numberOfPeople) {
		if(numberOfPeople < 4){
			throw new NumberOfPeopleIsBelowMinimumAllowedPeopleException();
		}
		if(numberOfPeople > 10){
			throw new NumberOfPeopleIsAboveMaximumAllowedPeopleException();
		}
	}

	public double getUnitCost(){
		return this.unitCost;
	}
	
	public static void setUnitCost(double newCost){
		GuidedHuntingActivity.unitCost = newCost;
	}
	
}
