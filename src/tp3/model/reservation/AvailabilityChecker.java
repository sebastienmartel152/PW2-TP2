package tp3.model.reservation;

public interface AvailabilityChecker {
	public boolean checkAvailability(int day, int month, int year, CottageType cottageType, int numberOfDays);
}
