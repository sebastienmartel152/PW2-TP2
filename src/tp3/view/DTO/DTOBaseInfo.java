package tp3.view.DTO;

import tp3.model.reservation.CottageType;
import tp3.model.reservation.TransportType;

public class DTOBaseInfo {
	public final CottageType cottageType;
	public final int numberOfPeople;
	public final int numberOfNights;
	public final TransportType transportTo;
	public final TransportType transportBack;
	public final boolean breakfastDinnerOption;
	public final boolean gastronomicSupperOption;
	
	public DTOBaseInfo(CottageType cottageType, int numberOfPeople, int numberOfNights,
			TransportType transportTo, TransportType transportBack,
			boolean breakfastDinnerOption, boolean gastronomicSupperOption){
		
		this.cottageType = cottageType;
		this.numberOfPeople = numberOfPeople;
		this.numberOfNights = numberOfNights;
		this.transportTo = transportTo;
		this.transportBack = transportBack;
		this.breakfastDinnerOption = breakfastDinnerOption;
		this.gastronomicSupperOption = gastronomicSupperOption;
	}
}
