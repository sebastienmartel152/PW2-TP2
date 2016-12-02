package tp3.model.reservation.repository;

import java.util.ArrayList;
import java.util.Collection;

import tp3.model.reservation.Reservation;

public class ReservationMemoryRepository implements ReservationRepository {
	
	private Collection<Reservation> reservations = new ArrayList<Reservation>();
	
	@Override
	public void add(Reservation reservation) {
		this.reservations.add(reservation);
		
	}

	@Override
	public ArrayList<Reservation> listAll() {
		return new ArrayList<Reservation>(this.reservations);
	}

	@Override
	public int count() {
		return this.reservations.size();
	}

}
