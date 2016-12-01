package tp2.cottage;

import org.junit.Test;

import tp3.model.cottage.NumberOfOccupantsExceedsMaximumCottageOccupantsException;
import tp3.model.cottage.SixPersonCottage;

public class SixPersonCottageTest {

	private static final int ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS = 7;
	private static final int ANY_NB_DAYS = 3;
	
	@Test(expected = NumberOfOccupantsExceedsMaximumCottageOccupantsException.class)
	public void SixPersonCottageConstructor_ShouldThrowNumberOfOccupantsExceedsMaximumCottageOccupantsExceptionIfNumberOfOccupantsIsSuperiorToMaximumOccupants(){
		
		new SixPersonCottage(ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS, ANY_NB_DAYS);	
	}
}
