package tp2.cottage;

public class CottageMock extends Cottage {

	private static final int ANY_COST = 100;

	public CottageMock(int numberOfOccupants) {
		super(numberOfOccupants);
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
