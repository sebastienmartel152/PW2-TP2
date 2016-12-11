package tp3.model.reservation;

import java.util.Random;

public class MockAvailabilityChecker implements AvailabilityChecker {
	
	public static final int FALSE = 1;
	public static final int TRUE = 2;
	public static final int RANDOM = 3;
	
	private boolean isAvailable;
	
	public MockAvailabilityChecker(int expectedBehavior){
		switch(expectedBehavior){
		case FALSE:
			isAvailable = false;
			break;
		case TRUE:
			isAvailable = true;
			break;
		case RANDOM:
		    Random random = new Random();
		    isAvailable = random.nextBoolean();
		    break;
		default:
			throw new IllegalArgumentException();
		}
		
	}
	
	@Override
	public boolean checkAvailability(int day, int month, int year, CottageType cottageType, int numberOfDays) {
		return isAvailable;
	}
	
}
