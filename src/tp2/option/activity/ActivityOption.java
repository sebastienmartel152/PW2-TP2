package tp2.option.activity;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public abstract class ActivityOption extends ReservationOption {
	
	public static final int MINIMUM_NB_OF_PEOPLE = 1;
	private int numberOfPeople;

	public ActivityOption(Reservation reservation, int numberOfPeople) {
		super(reservation);
		validateNumberOfPeople(numberOfPeople);
		this.numberOfPeople = numberOfPeople;
	}

	private void validateNumberOfPeople(int numberOfPeople) {
		if(numberOfPeople < MINIMUM_NB_OF_PEOPLE){
			throw new NumberOfPeopleIsBelow0Exception();
		}
	}
	
	public int getNumberOfPeople(){
		return this.numberOfPeople;
	}
}
