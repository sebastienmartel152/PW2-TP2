package tp2.option;

import tp2.reservation.Reservation;

public abstract class ReservationOption implements Reservation{
	private Reservation currentReservation;
	
	public ReservationOption(Reservation reservation){
		this.currentReservation = reservation;
	}
	
	public double calculateTotalCost(){
		return this.currentReservation.calculateTotalCost() + this.getUnitCost();
	}
}
