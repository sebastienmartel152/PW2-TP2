package tp2.option.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cottage.CottageMock;
import tp2.reservation.Reservation;

public class GuidedHuntingActivityTest {
	
	private static final int ANY_NUMBER_OF_PEOPLE_BELOW_MINIMUM_LIMIT_OF_4 = 2;
	private static final int ANY_NUMBER_OF_PEOPLE_ABOVE_MAXIMUM_LIMIT_OF_10 = 13;
	private static final int ANY_NUMBER_OF_PEOPLE_IN_COTTAGE = 4;

	@Test(expected = NumberOfPeopleIsAboveMaximumAllowedPeopleException.class)
	public void GuidedHuntingActivity_ShouldRaiseNumberOfPeopleIsAboveMaximumAllowedPeopleExceptionIfNumberOfPeopleIsAboveMaximumPeopleOf10(){
		//Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE_IN_COTTAGE);
		new GuidedHuntingActivity(cottage, ANY_NUMBER_OF_PEOPLE_ABOVE_MAXIMUM_LIMIT_OF_10);
		//Act
		
		//Assert
	}
	
	@Test(expected = NumberOfPeopleIsBelowMinimumAllowedPeopleException.class)
	public void GuidedHuntingActivity_ShouldRaiseNumberOfPeopleIsBelowMinimumAllowedPeopleExceptionIfNumberOfPeopleIsBelowMinimumPeopleOf4(){
		//Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE_IN_COTTAGE);
		new GuidedHuntingActivity(cottage, ANY_NUMBER_OF_PEOPLE_BELOW_MINIMUM_LIMIT_OF_4);
		//Act
		
		//Assert
	}
	
	@Test
	public void GuidedHuntingActivityDecorator_calculateTotalCost_shouldAddPriceToBaseCottagePrice() {
		// Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE_IN_COTTAGE);
		Reservation cottageWithActivity = new GuidedHuntingActivity(cottage, ANY_NUMBER_OF_PEOPLE_IN_COTTAGE);
		
		final double EXPECTED_PRICE = cottage.calculateTotalCost() + 
			GuidedHuntingActivity.DEFAULT_COST;
		
		// Act
		double actualPrice = cottageWithActivity.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualPrice, 0.00);
	}

}
