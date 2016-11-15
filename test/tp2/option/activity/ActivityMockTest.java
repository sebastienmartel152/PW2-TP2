package tp2.option.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cottage.CottageMock;
import tp2.reservation.Reservation;

public class ActivityMockTest {
	public static final int ANY_NUMBER_OF_PEOPLE = 4;
	
	
	@Test
	public void ActivityOptionDecorator_calculateTotalCost_shouldAddPriceToBaseCottagePrice() {
		// Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE);
		
		final double EXPECTED_PRICE = cottage.calculateTotalCost() + 
			ActivityMock.ANY_COST_PER_PERSON * ANY_NUMBER_OF_PEOPLE;
		
		// Act
		Reservation cottageWithActivity = new ActivityMock(cottage, ANY_NUMBER_OF_PEOPLE);
		double actualPrice = cottageWithActivity.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualPrice, 0.00);
	}
	
	@Test (expected=NumberOfPeopleIsBelow0Exception.class)
	public void ActivityOption_with0People_shouldRaiseNumberOfPeopleBelow0Exception(){
		// Arrange
		int nbPeople = 0;
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE);
		
		// Act & Assert
		new ActivityMock(cottage, nbPeople);
	}

}
