package tp2.option.activity;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public class GuidedHuntingActivity extends ReservationOption {
	
	public static final int MAXIMUM_PEOPLE = 10;
	public static final int MINIMUM_PEOPLE = 4;
	public static final double DEFAULT_COST = 200;
	private static double unitCost = DEFAULT_COST;
	
	public GuidedHuntingActivity(Reservation reservation, int numberOfPeople) {
		super(reservation);
		validateNumberOfPeople(numberOfPeople);
	}
	
	private void validateNumberOfPeople(int numberOfPeople) {
		if(numberOfPeople < MINIMUM_PEOPLE){
			throw new NumberOfPeopleIsBelowMinimumAllowedPeopleException();
		}
		if(numberOfPeople > MAXIMUM_PEOPLE){
			throw new NumberOfPeopleIsAboveMaximumAllowedPeopleException();
		}
	}

	public double getUnitCost(){
		return GuidedHuntingActivity.unitCost;
	}
	
	public static void setUnitCost(double newCost){
		GuidedHuntingActivity.unitCost = newCost;
	}
	
}
