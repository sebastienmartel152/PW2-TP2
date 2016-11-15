package tp2.option.deal;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.cottage.CottageMock;
import tp2.cottage.FourPersonCottage;
import tp2.reservation.Reservation;

public class FishingDealTest {

	private static final int ANY_NB_OF_PEOPLE = 4;

	@Test
	public void FishingDeal_applies_a_25_percent_off_price_on_current_reservation() {
		
		//Arrange
		Reservation cottageMock = new CottageMock(ANY_NB_OF_PEOPLE);
		Reservation cottageWithFishingDeal = new FishingDeal(cottageMock);
		//Act
		double currentPrice = cottageWithFishingDeal.calculateTotalCost();
		//Assert
		final double EXPECTED_PRICE = cottageMock.getUnitCost() * (1 - FishingDeal.DEFAULT_PERCENTAGE_OFF);
		assertEquals(EXPECTED_PRICE, currentPrice, 0.00);
	}

}
