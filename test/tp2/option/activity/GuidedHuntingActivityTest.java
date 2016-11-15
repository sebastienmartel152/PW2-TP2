package tp2.option.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cottage.CottageMock;
import tp2.reservation.Reservation;

public class GuidedHuntingActivityTest {
	

	private static final int ANY_NUMBER_OF_PEOPLE_IN_COTTAGE = 4;

	@Test(expected = NumberOfPeopleIsAboveMaximumAllowedPeopleException.class)
	public void GuidedHuntingActivity_ShouldRaiseNumberOfPeopleIsAboveMaximumAllowedPeopleExceptionIfNumberOfPeopleIsAboveMaximumPeopleOf10(){
		//Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE_IN_COTTAGE);
		
		//Act
		new GuidedHuntingActivity(cottage, GuidedHuntingActivity.MAXIMUM_PEOPLE + 1);
		
		//Assert
	}
	
	@Test(expected = NumberOfPeopleIsBelowMinimumAllowedPeopleException.class)
	public void GuidedHuntingActivity_ShouldRaiseNumberOfPeopleIsBelowMinimumAllowedPeopleExceptionIfNumberOfPeopleIsBelowMinimumPeopleOf4(){
		//Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE_IN_COTTAGE);
		
		//Act
		new GuidedHuntingActivity(cottage, GuidedHuntingActivity.MINIMUM_PEOPLE - 1);
		
		//Assert
	}
	
	@Test
	public void GuidedHuntingActivityDecorator_calculateTotalCost_shouldAddPriceToBaseCottagePrice() {
		// Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE_IN_COTTAGE);
		
		final double EXPECTED_PRICE = cottage.calculateTotalCost() + 
			GuidedHuntingActivity.DEFAULT_COST;
		
		// Act
		Reservation cottageWithActivity = new GuidedHuntingActivity(cottage, ANY_NUMBER_OF_PEOPLE_IN_COTTAGE);
		double actualPrice = cottageWithActivity.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualPrice, 0.00);
	}

}
