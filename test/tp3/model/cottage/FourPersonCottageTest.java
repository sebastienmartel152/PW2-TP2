package tp3.model.cottage;

import org.junit.Test;

import tp3.model.cottage.FourPersonCottage;
import tp3.model.cottage.NumberOfOccupantsExceedsMaximumCottageOccupantsException;

public class FourPersonCottageTest {

	private static final int ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS = 5;
	private static final int ANY_NB_DAYS = 3;
	
	@Test(expected = NumberOfOccupantsExceedsMaximumCottageOccupantsException.class)
	public void FourPersonCottageConstructor_ShouldThrowNumberOfOccupantsExceedsMaximumCottageOccupantsExceptionIfNumberOfOccupantsIsSuperiorToMaximumOccupants(){
		
		new FourPersonCottage(ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS, ANY_NB_DAYS);	
	}
}
