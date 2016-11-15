package tp2.option.deal;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public class FishingDeal extends ReservationOption {
	
	public static final double DEFAULT_PERCENTAGE_OFF = 0.25;
	private static double percentageOff = DEFAULT_PERCENTAGE_OFF;
	private Reservation reservation;
	
	public FishingDeal(Reservation reservation){
		super(reservation);
		this.reservation = reservation;
		
	}

	@Override
	public double getUnitCost() {
		return 0;
	}
	
	@Override
	public double calculateTotalCost(){
		return this.reservation.calculateTotalCost() * (1 - percentageOff); 
	}
	public void setPercentageOff(double newPercentage){
		FishingDeal.percentageOff = newPercentage;
	}

}