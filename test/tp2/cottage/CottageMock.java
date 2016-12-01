package tp2.cottage;

import tp3.model.cottage.Cottage;

public class CottageMock extends Cottage {
	public static final int ANY_COST = 100;
	public static final int ANY_NUMBER_OF_DAYS = 3;
	
	public CottageMock(int numberOfOccupants) {
		super(numberOfOccupants, ANY_NUMBER_OF_DAYS);
	}

	@Override
	public double getOptionCost() {
		return ANY_COST;
	}

	@Override
	public double calculateTotalCost() {
		return getOptionCost();
	}

	
}
