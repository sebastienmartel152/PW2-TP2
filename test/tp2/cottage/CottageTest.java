package tp2.cottage;

import static org.junit.Assert.*;

import org.junit.Test;

import tp3.model.cottage.Cottage;

public class CottageTest {

	private static final int ANY_NUMBER_OF_OCCUPANTS = 3;

	@Test
	public void createCottage_getUnitCost_shouldGiveCorrectPrice() {
		// Arrange
		Cottage newCottage = new CottageMock(ANY_NUMBER_OF_OCCUPANTS);
		final double EXPECTED_PRICE = CottageMock.ANY_COST;
		
		// Act
		double actualCost = newCottage.getOptionCost();
		
		// Assert
		
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}

}
