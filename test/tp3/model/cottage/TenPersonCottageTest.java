package tp3.model.cottage;

import org.junit.Test;

import tp3.model.cottage.NumberOfOccupantsExceedsMaximumCottageOccupantsException;
import tp3.model.cottage.TenPersonCottage;

public class TenPersonCottageTest {

	private static final int ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS = 11;
	private static final int ANY_NB_DAYS = 3;
	
	@Test(expected = NumberOfOccupantsExceedsMaximumCottageOccupantsException.class)
	public void TenPersonCottageConstructor_ShouldThrowNumberOfOccupantsExceedsMaximumCottageOccupantsExceptionIfNumberOfOccupantsIsSuperiorToMaximumOccupants(){
		
		new TenPersonCottage(ANY_NB_OCCUPANTS_ABOVE_MAX_OCCUPANTS, ANY_NB_DAYS);
	}
}
