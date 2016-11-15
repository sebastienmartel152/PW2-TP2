package tp2.option.meal;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cottage.CottageMock;
import tp2.reservation.Reservation;

public class MealOptionTest {
	
	private static final int ANY_NUMBER_OF_PEOPLE = 4;
	private static final int ANY_NUMBER_OF_DAYS = 3;
	
	@Test
	public void MealOptionDecorator_calculateTotalCost_shouldAddMealPriceToBaseCottagePrice() {
		// Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE);
		
		
		final double EXPECTED_PRICE = cottage.calculateTotalCost() + 
				MealOptionMock.ANY_COST_PER_MEAL_PER_PERSON * ANY_NUMBER_OF_PEOPLE * ANY_NUMBER_OF_DAYS;
		// Act
		Reservation cottageWithMeals = new MealOptionMock(cottage, ANY_NUMBER_OF_PEOPLE, ANY_NUMBER_OF_DAYS);
		
		double actualPrice = cottageWithMeals.calculateTotalCost();
		
		// Assert
		
		assertEquals(EXPECTED_PRICE, actualPrice, 0.00);
	}

}
