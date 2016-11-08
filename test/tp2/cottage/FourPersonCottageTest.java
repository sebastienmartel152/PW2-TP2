package tp2.cottage;

import org.junit.Test;

public class FourPersonCottageTest {

	private static final int ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS = 5;

	@Test(expected = NumberOfOccupantsExceedsMaximumCottageOccupantsException.class)
	public void FourPersonCottageConstructor_ShouldThrowNumberOfOccupantsExceedsMaximumCottageOccupantsExceptionIfNumberOfOccupantsIsSuperiorToMaximumOccupants(){
		
		new FourPersonCottage(ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS);	
	}
}
