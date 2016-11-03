package tp2.cottage;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.reservation.Reservation;

public class TenPersonCottageTest {

	private static final int ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS = 11;

	@Test(expected = NumberOfOccupantsExceedsMaximumCottageOccupantsException.class)
	public void TenPersonCottageConstructor_ShouldThrowNumberOfOccupantsExceedsMaximumCottageOccupantsExceptionIfNumberOfOccupantsIsSuperiorToMaximumOccupants(){
		
		Reservation tenPersonCottage = new TenPersonCottage(ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS);
	}
}
