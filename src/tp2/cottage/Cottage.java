package tp2.cottage;
import tp2.reservation.*;

public abstract class Cottage implements Reservation {
	
	private int numberOfOccupants;
	
	public Cottage(int numberOfOccupants){
		
		this.numberOfOccupants = numberOfOccupants;
		
	}
	
	public int getNumberOfOccupants(){
		return this.numberOfOccupants;
	}
	
}
