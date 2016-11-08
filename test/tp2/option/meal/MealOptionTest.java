package tp2.option.meal;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cottage.CottageMock;
import tp2.reservation.Reservation;

public class MealOptionTest {
	private static final int ANY_NUMBER_OF_DAYS = 3;
	private static final int ANY_NUMBER_OF_PEOPLE = 3;
	
	@Test
	public void MealOptionDecorator_calculateTotalCost_shouldAddPriceToBaseCottagePrice() {
		// Arrange
		Reservation cottage = new CottageMock(ANY_NUMBER_OF_PEOPLE);
		Reservation cottageWithMeal = new MealOptionMock(cottage, ANY_NUMBER_OF_PEOPLE, ANY_NUMBER_OF_DAYS);
		
		final double EXPECTED_PRICE = cottage.calculateTotalCost() +
				MealOptionMock.ANY_COST_PER_DAY_PER_PERSON * ANY_NUMBER_OF_PEOPLE * ANY_NUMBER_OF_DAYS;
		
		// Act
		double actualPrice = cottageWithMeal.calculateTotalCost();
		
		// Assert
		
		assertEquals(EXPECTED_PRICE, actualPrice, 0.00);
	}

}
