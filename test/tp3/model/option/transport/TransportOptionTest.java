package tp3.model.option.transport;

import static org.junit.Assert.*;

import org.junit.Test;

import tp3.model.cottage.CottageMock;
import tp3.model.reservation.Reservation;

public class TransportOptionTest {
	private static final int ANY_NUMBER_OF_PEOPLE = 3;
	
	@Test
	public void TransportDecorator_calculateTotalCost_shouldAddCostToBaseCottageCost() {
		// Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE);
		Reservation cottageWithTransport = new TransportOptionMock(cottage, ANY_NUMBER_OF_PEOPLE);
		
		final double EXPECTED_PRICE = cottage.calculateTotalCost() + TransportOptionMock.ANY_COST;
		
		// Act
		double actualPrice = cottageWithTransport.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualPrice, 0.00);
	}

}
