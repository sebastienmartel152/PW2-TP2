package tp3.model.cottage;

public class TenPersonCottage extends Cottage {

	public static final double DEFAULT_COTTAGE_PRICE = 300;
	private static double cottagePrice = DEFAULT_COTTAGE_PRICE;
	public static final int MAXIMUM_OCCUPANTS = 10;
	
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
	public double getOptionCost() {
		return TenPersonCottage.cottagePrice * super.getNumberOfDays();
	}

	@Override
	public double calculateTotalCost(){
		return this.getOptionCost();
	}
	
	public static void setCottagePrice(double newPrice){
		TenPersonCottage.cottagePrice = newPrice;
	}
	
	public static double getCottagePrice(){
		return TenPersonCottage.cottagePrice;
	}
}
