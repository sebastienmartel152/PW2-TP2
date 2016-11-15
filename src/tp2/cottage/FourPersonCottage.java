package tp2.cottage;

public class FourPersonCottage extends Cottage {

	private static final int DEFAULT_COTTAGE_PRICE = 150;
	private static double cottagePrice = DEFAULT_COTTAGE_PRICE;
	public static final int MAXIMUM_OCCUPANTS = 4;
	
	public FourPersonCottage(int numberOfOccupants, int numberOfDays){
		
		super(numberOfOccupants, numberOfDays);
		verifyNumberOfOccupants(numberOfOccupants);
	}

	private void verifyNumberOfOccupants(int numberOfOccupants) {
		if(numberOfOccupants>MAXIMUM_OCCUPANTS){
			throw new NumberOfOccupantsExceedsMaximumCottageOccupantsException();
		}
	}

	@Override
	public double getUnitCost() {
		return FourPersonCottage.cottagePrice * super.getNumberOfDays();
	}

	@Override
	public double calculateTotalCost(){
		return this.getUnitCost();
	}
	
	public static void setCottagePrice(double newPrice){
		FourPersonCottage.cottagePrice = newPrice;
	}
}