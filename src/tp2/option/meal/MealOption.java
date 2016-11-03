package tp2.option.meal;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public abstract class MealOption extends ReservationOption{

	public MealOption(Reservation reservation) {
		super(reservation);
	}

}
