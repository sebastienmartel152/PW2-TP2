package tp2.option.activity;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public abstract class ActivityOption extends ReservationOption {
	
	private int numberOfPeople;

	public ActivityOption(Reservation reservation, int numberOfPeople) {
		super(reservation);
		validateNumberOfPeople(numberOfPeople);
		this.numberOfPeople = numberOfPeople;
	}

	private void validateNumberOfPeople(int numberOfPeople) {
		if(numberOfPeople < 1){
			throw new NumberOfPeopleIsBelow0Exception();
		}
	}
	
	public int getNumberOfPeople(){
		return this.numberOfPeople;
	}
}
