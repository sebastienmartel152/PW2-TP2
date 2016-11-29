package tp2.option.deal;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public class FamilyDeal extends ReservationOption {  // @SM: vous auriez pu faire une classe abstraite Deal..
	
	public static final double DEFAULT_PERCENTAGE_OFF = 0.2;
	private static double percentageOff = DEFAULT_PERCENTAGE_OFF;
	private Reservation reservation;
	
	public FamilyDeal(Reservation reservation){
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
		FamilyDeal.percentageOff = newPercentage;
	}

}
