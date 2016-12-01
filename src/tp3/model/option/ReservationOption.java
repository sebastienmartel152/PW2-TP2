package tp3.model.option;

import tp3.model.reservation.Reservation;

public abstract class ReservationOption implements Reservation{
	private Reservation currentReservation;
	
	public ReservationOption(Reservation reservation){
		this.currentReservation = reservation;
	}
	
	@Override
	public double calculateTotalCost(){
		return this.currentReservation.calculateTotalCost() + this.getOptionCost();
	}
}
