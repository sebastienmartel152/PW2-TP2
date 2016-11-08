package tp2.option.service;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cottage.CottageMock;
import tp2.reservation.Reservation;

public class ServiceOptionTest {
	public static final int ANY_NUMBER_OF_OCCUPANTS = 4;
	public static final int ANY_NUMBER_OF_DAYS = 2;
	
	@Test
	public void ServiceOptionDecorator_calculateTotalCost_shouldAddPriceToBaseCottagePrice() {
		// Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_OCCUPANTS);
		Reservation cottageWithService = new ServiceOptionMock(cottage, ANY_NUMBER_OF_DAYS);
		
		final double EXPECTED_PRICE = cottage.calculateTotalCost() + 
			ServiceOptionMock.ANY_COST_PER_DAY * ANY_NUMBER_OF_DAYS;
		
		// Act
		double actualPrice = cottageWithService.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualPrice, 0.00);
	}
	
	@Test (expected=NumberOfDaysMustBeGreaterThan0.class)
	public void ServiceOption_with0Days_shouldRaiseNumberOfDaysMustBeGreaterThan0Exception(){
		// Arrange
		int nbDays = 0;
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_OCCUPANTS);
		
		// Act & Assert
		new ServiceOptionMock(cottage, nbDays);
	}

}
