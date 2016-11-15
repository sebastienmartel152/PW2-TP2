package tp2.cottage;

public class TenPersonCottage extends Cottage {

	private static final double DEFAULT_COTTAGE_PRICE = 300;
	private static double cottagePrice = DEFAULT_COTTAGE_PRICE;
	private static final int MAXIMUM_OCCUPANTS = 10;
	
	public TenPersonCottage(int numberOfOccupants, int numberOfDays){
		
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
		return TenPersonCottage.cottagePrice * super.getNumberOfDays();
	}

	@Override
	public double calculateTotalCost(){
		return this.getUnitCost();
	}
	
	public static void setCottagePrice(double newPrice){
		TenPersonCottage.cottagePrice = newPrice;
	}
}
