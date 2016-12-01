package tp3.model.option.meal;

import static org.junit.Assert.*;

import org.junit.Test;

import tp3.model.cottage.CottageMock;
import tp3.model.reservation.Reservation;

public class MealOptionTest {

	private static final int ANY_NUMBER_OF_PEOPLE = 4;
	private static final int ANY_NUMBER_OF_DAYS = 3;
	
	@Test
	public void MealOptionDecorator_calculateTotalCost_shouldAddMealPriceToBaseCottagePrice() {
		// Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE);
		
		
		final double EXPECTED_PRICE = cottage.calculateTotalCost() + 
				MealOptionMock.ANY_COST;
		// Act
		Reservation cottageWithMeals = new MealOptionMock(cottage, ANY_NUMBER_OF_PEOPLE, ANY_NUMBER_OF_DAYS);
		
		double actualPrice = cottageWithMeals.calculateTotalCost();

		
		// Assert
		
		assertEquals(EXPECTED_PRICE, actualPrice, 0.00);
	}

}
