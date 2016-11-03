package tp2.cottage;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.reservation.Reservation;

public class SixPersonCottageTest {

	private static final int ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS = 7;

	@Test(expected = NumberOfOccupantsExceedsMaximumCottageOccupantsException.class)
	public void SixPersonCottageConstructor_ShouldThrowNumberOfOccupantsExceedsMaximumCottageOccupantsExceptionIfNumberOfOccupantsIsSuperiorToMaximumOccupants(){
		
		Reservation sixPersonCottage = new SixPersonCottage(ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS);	
	}
}
