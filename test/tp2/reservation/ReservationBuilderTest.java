package tp2.reservation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tp2.cottage.FourPersonCottage;
import tp2.option.meal.*;
import tp2.option.service.*;
import tp2.option.transport.*;
import tp2.option.activity.*;
import tp2.option.deal.FamilyDeal;
import tp2.option.deal.FishingDeal;

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
	public void FamilyDeal_builder_shouldHaveCorrectPrice(){
		// Arrange
		ReservationBuilder FamilyDealBuilder = new ReservationBuilder();
		FamilyDealBuilder.FamilyDeal(ANY_NUMBER_OF_DAYS);
		
		final double EXPECTED_DEAL_PRICE = (1-FamilyDeal.DEFAULT_PERCENTAGE_OFF) * (
				  FourPersonCottage.DEFAULT_COTTAGE_PRICE * ANY_NUMBER_OF_DAYS
				+ 2 * TransportBoat.DEFAULT_COST_PER_PERSON * ANY_NUMBER_OF_PEOPLE
				+ MealSupper.DEFAULT_COST_PER_PERSON_PER_SUPPER * ANY_NUMBER_OF_PEOPLE * ANY_NUMBER_OF_DAYS
				+ MealGastronomicSupper.DEFAULT_COST_PER_PERSON_PER_SUPPER * ANY_NUMBER_OF_PEOPLE * ANY_NUMBER_OF_DAYS
				+ TrappingActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE
				+ BeaverObservationActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE
				+ FishSmokingActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE );
		
		// Arrange
		Reservation reservation = FamilyDealBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Act
		assertEquals(EXPECTED_DEAL_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void FishingDeal_builder_shouldHaveCorrectPrice(){
		// Arrange
		ReservationBuilder FamilyDealBuilder = new ReservationBuilder();
		FamilyDealBuilder.FishingDeal(ANY_COTTAGE_TYPE, ANY_NUMBER_OF_PEOPLE, ANY_NUMBER_OF_DAYS);
		
		final double EXPECTED_DEAL_PRICE = (1-FishingDeal.DEFAULT_PERCENTAGE_OFF) * (
				  FourPersonCottage.DEFAULT_COTTAGE_PRICE * ANY_NUMBER_OF_DAYS
				+ 2 * TransportBoat.DEFAULT_COST_PER_PERSON * ANY_NUMBER_OF_PEOPLE
				+ MealSupper.DEFAULT_COST_PER_PERSON_PER_SUPPER * ANY_NUMBER_OF_PEOPLE * ANY_NUMBER_OF_DAYS
				+ FishingActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE
				+ BaitBuildingActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE
				+ GuidedHuntingActivity.DEFAULT_COST
				+ FishSmokingActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE );
		
		// Arrange
		Reservation reservation = FamilyDealBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Act
		assertEquals(EXPECTED_DEAL_PRICE, actualCost, 0.00);
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
		reservationBuilder.withBreakfastDinner(ANY_NUMBER_OF_PEOPLE, ANY_NUMBER_OF_DAYS);
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
		reservationBuilder.withGastronomicSupper(ANY_NUMBER_OF_PEOPLE, ANY_NUMBER_OF_DAYS);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithCleaningService_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ CleaningService.DEFAULT_COST_PER_DAY * ANY_NUMBER_OF_DAYS;
		
		// Act
		reservationBuilder.withCleaningService(ANY_NUMBER_OF_DAYS);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithATVService_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ ATVService.DEFAULT_COST_PER_DAY* ANY_NUMBER_OF_DAYS;
		
		// Act
		reservationBuilder.withATVService(ANY_NUMBER_OF_DAYS);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithElectricMotorService_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ ElectricMotorService.DEFAULT_COST_PER_DAY* ANY_NUMBER_OF_DAYS;
		
		// Act
		reservationBuilder.withElectricMotorService(ANY_NUMBER_OF_DAYS);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithExtraBoatService_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ ExtraBoatService.DEFAULT_COST_PER_DAY* ANY_NUMBER_OF_DAYS;
		
		// Act
		reservationBuilder.withExtraBoatService(ANY_NUMBER_OF_DAYS);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithBaitBuildingActivity_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ BaitBuildingActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE;
		
		// Act
		reservationBuilder.withBaitBuildingActivity(ANY_NUMBER_OF_PEOPLE);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithBeaverObservationActivity_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ BeaverObservationActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE;
		
		// Act
		reservationBuilder.withBeaverObservationActivity(ANY_NUMBER_OF_PEOPLE);
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
		reservationBuilder.withBlackBearObservationActivity(ANY_NUMBER_OF_PEOPLE);
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
		reservationBuilder.withFishingActivity(ANY_NUMBER_OF_PEOPLE);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithFishSmokingActivity_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ FishSmokingActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE;
		
		// Act
		reservationBuilder.withFishSmokingActivity(ANY_NUMBER_OF_PEOPLE);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithGuidedHuntingActivity_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ GuidedHuntingActivity.DEFAULT_COST;
		
		// Act
		reservationBuilder.withGuidedHuntingActivity(ANY_NUMBER_OF_PEOPLE);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
	@Test
	public void BuilderWithTrappingActivity_shouldAddDecoratorPrice_toBasePrice(){
		// Arrange
		final double EXPECTED_PRICE = EXPECTED_BASE_PRICE
				+ TrappingActivity.DEFAULT_COST * ANY_NUMBER_OF_PEOPLE;
		
		// Act
		reservationBuilder.withTrappingActivity(ANY_NUMBER_OF_PEOPLE);
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
		reservationBuilder.withWolfObservationActivity(ANY_NUMBER_OF_PEOPLE);
		Reservation reservation = reservationBuilder.build();
		double actualCost = reservation.calculateTotalCost();
		
		// Assert
		assertEquals(EXPECTED_PRICE, actualCost, 0.00);
	}
	
}
