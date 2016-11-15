package tp2.cottage;
import tp2.reservation.*;

public abstract class Cottage implements Reservation {
	
	private int numberOfOccupants;
	private int numberOfDays;
	
	public Cottage(int numberOfOccupants, int numberOfDays){
		this.numberOfOccupants = numberOfOccupants;
		this.numberOfDays = numberOfDays;
		
	}
	
	public int getNumberOfOccupants(){
		return this.numberOfOccupants;
	}
	
	public int getNumberOfDays(){
		return this.numberOfDays;
	}
	
}
