package tp2.cottage;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.reservation.Reservation;

public class FourPersonCottageTest {

	private static final int ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS = 5;

	@Test(expected = NumberOfOccupantsExceedsMaximumCottageOccupantsException.class)
	public void FourPersonCottageConstructor_ShouldThrowNumberOfOccupantsExceedsMaximumCottageOccupantsExceptionIfNumberOfOccupantsIsSuperiorToMaximumOccupants(){
		
		Reservation fourPersonCottage = new FourPersonCottage(ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS);	
	}
}
