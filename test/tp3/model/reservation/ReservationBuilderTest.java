package tp3.model.reservation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tp3.model.cottage.FourPersonCottage;
import tp3.model.option.activity.*;
import tp3.model.option.meal.*;
import tp3.model.option.transport.*;
import tp3.model.reservation.CottageType;
import tp3.model.reservation.Reservation;
import tp3.model.reservation.ReservationBuilder;
import tp3.model.reservation.TransportType;

public class ReservationBuilderTest {
	
	private static final int ANY_NUMBER_OF_PEOPLE = 4;
	private static final int ANY_NUMBER_OF_DAYS = 7;
	private static final CottageType ANY_COTTAGE_TYPE = CottageType.FOURPERSON;
	private static final TransportType ANY_TRANSPORT_TO = TransportType.BOAT;
	private static final TransportType ANY_TRANSPORT_FROM = TransportType.HYDROPLANE;
	
	private ReservationBuilder reservationBuilder;
	private double EXPECTED_BASE_PRICE;
	
	@Before
	public void initializeBuilder() {
		reservationBuilder = new ReservationBuilder(ANY_COTTAGE_TYPE, ANY_NUMBER_OF_PEOPLE, ANY_NUMBER_OF_DAYS,
				ANY_TRANSPORT_TO, ANY_TRANSPORT_FROM);
		
		EXPECTED_BASE_PRICE = FourPersonCottage.DEFAULT_COTTAGE_PRICE * ANY_NUMBER_OF_DAYS
				+ TransportBoat.DEFAULT_COST_PER_PERSON * ANY_NUMBER_OF_PEOPLE
				+ TransportHydroplane.DEFAULT_COST_PER_PERSON * ANY_NUMBER_OF_PEOPLE
				+ MealSupper.DEFAULT_COST_PER_PERSON_PER_SUPPER * ANY_NUMBER_OF_PEOPLE * ANY_NUMBER_OF_DAYS;
	}
	
	@Test
	public void standardBuilder_withNoDecorator_shouldGiveCorrectPrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE;
		
		// Act
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithBreakfastDinner_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ MealBreakfastDinner.DEFAULT_COST_PER_PERSON_PER_BREAKFAST * ANY_NUMBER_OF_DAYS * ANY_NUMBER_OF_PEOPLE;
		
		
		// Act
		reservationBuilder.withBreakfastDinner();
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithGastronomicSupper_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ MealGastronomicSupper.DEFAULT_COST_PER_PERSON_PER_SUPPER * ANY_NUMBER_OF_DAYS * ANY_NUMBER_OF_PEOPLE;
		
		
		// Act
		reservationBuilder.withGastronomicSupper();
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	
	@Test
	public void BuilderWithBlackBearObservationActivity_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ BlackBearObservationActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE;
		
		// Act
		reservationBuilder.withBlackBearObservationActivity();
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithFishingActivity_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ FishingActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE;
		
		// Act
		reservationBuilder.withFishingActivity();
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithWolfObservationActivity_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ WolfObservationActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE;
		
		// Act
		reservationBuilder.withWolfObservationActivity();
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
}
