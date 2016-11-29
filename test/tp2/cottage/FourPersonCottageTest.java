package tp2.cottage;

import org.junit.Test;

public class FourPersonCottageTest {   //@SM: pour les cottages: tester le comportement de getUnitCost

	private static final int ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS = 5;
	private static final int ANY_NB_DAYS = 3;
	
	@Test(expected = NumberOfOccupantsExceedsMaximumCottageOccupantsException.class)
	public void FourPersonCottageConstructor_ShouldThrowNumberOfOccupantsExceedsMaximumCottageOccupantsExceptionIfNumberOfOccupantsIsSuperiorToMaximumOccupants(){
		
		new FourPersonCottage(ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS, ANY_NB_DAYS);	
	}
}
