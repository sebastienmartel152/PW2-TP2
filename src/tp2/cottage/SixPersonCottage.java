package tp2.cottage;

public class SixPersonCottage extends Cottage {

	public static final double DEFAULT_COTTAGE_PRICE = 200;
	private static double cottagePrice = DEFAULT_COTTAGE_PRICE;
	public static final int MAXIMUM_OCCUPANTS = 6;
	
	public SixPersonCottage(int numberOfOccupants, int numberOfDays){
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
		return SixPersonCottage.cottagePrice * super.getNumberOfDays();
	}

	@Override
	public double calculateTotalCost(){
		return this.getUnitCost();
	}
	
	public static void setCottagePrice(double newPrice){
		SixPersonCottage.cottagePrice = newPrice;
	}
}
