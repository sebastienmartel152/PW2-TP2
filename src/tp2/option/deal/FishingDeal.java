package tp2.option.deal;

import tp2.option.ReservationOption;
import tp2.reservation.Reservation;

public class FishingDeal extends ReservationOption {
	
	public static final double DEFAULT_PERCENTAGE_OFF = 0.25;
	private static double percentageOff = DEFAULT_PERCENTAGE_OFF;
	private Reservation reservation;        //@SM: NON! Vous avez d�j� une propri�t� h�rit�e par BookingOption. Attention: c'est du "hiding". Vous g�rez la redondance mais c'est dangereux, source de bogue.
										    //@SM: simplement rajouter une m�thode getReservation() dans ReservationOption si vous en avez besoin.
	
	public FishingDeal(Reservation reservation){
		super(reservation);
		this.reservation = reservation;
		
	}

	@Override
	public double getUnitCost() {
		return 0;   // @SM: ?? Pourquoi ne pas renvoyer le pourcentage off? � cause du nom de la m�thode? Possible de renommer la m�thode?
	}
	
	@Override
	public double calculateTotalCost(){
		return this.reservation.calculateTotalCost() * (1 - percentageOff); 
	}
	public void setPercentageOff(double newPercentage){  //@SM: m�thode statique!!
		FishingDeal.percentageOff = newPercentage;
	}

}