package tp2.reservation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tp2.cottage.FourPersonCottage;
import tp2.option.meal.MealSupper;
import tp2.option.transport.TransportBoat;
import tp2.option.transport.TransportHydroplane;

public class ReservationBuilderTest {
	
	private static final int ANY_NUMBER_OF_PEOPLE = 4;
	private static final int ANY_NUMBER_OF_DAYS = 7;
	private static final CottageType ANY_COTTAGE_TYPE = CottageType.FOURPERSON;
	private static final TransportType ANY_TRANSPORT_TO = TransportType.BOAT;
	private static final TransportType ANY_TRANSPORT_FROM = TransportType.HYDROPLANE;
	
	private ReservationBuilder reservationBuilder;
	
	@Before
	public void initializeBuilder() {
		reservationBuilder = new ReservationBuilder(ANY_COTTAGE_TYPE, ANY_NUMBER_OF_PEOPLE, ANY_NUMBER_OF_DAYS,
				ANY_TRANSPORT_TO, ANY_TRANSPORT_FROM);
	}

	@Test
	public void standardBuilder_withNoDecorator_shouldGiveCorrectPrice(){
		// Arrange
		final double EXPECTED_BASE_PRICE = FourPersonCottage.DEFAULT_COTTAGE_PRICE * ANY_NUMBER_OF_DAYS
				+ TransportBoat.DEFAULT_COST_PER_PERSON * ANY_NUMBER_OF_PEOPLE
				+ TransportHydroplane.DEFAULT_COST_PER_PERSON * ANY_NUMBER_OF_PEOPLE
				+ MealSupper.DEFAULT_COST_PER_PERSON_PER_SUPPER * ANY_NUMBER_OF_PEOPLE * ANY_NUMBER_OF_DAYS;
		
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE;
		
		// Act
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
}
