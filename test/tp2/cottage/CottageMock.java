package tp2.cottage;

public class CottageMock extends Cottage {
	private static final int ANY_COST = 100;
	private static final int ANY_NUMBER_OF_DAYS = 3;
	
	public CottageMock(int numberOfOccupants) {
		super(numberOfOccupants, ANY_NUMBER_OF_DAYS);
	}

	@Override
	public double getUnitCost() {
		return ANY_COST;
	}

	@Override
	public double calculateTotalCost() {
		return getUnitCost();
	}

	
}
