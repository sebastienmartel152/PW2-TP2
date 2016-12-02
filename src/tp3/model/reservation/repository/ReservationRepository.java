package tp3.model.reservation.repository;

import java.util.ArrayList;

import tp3.model.reservation.Reservation;


public interface ReservationRepository {
	
	public void add(Reservation reservation);
	public ArrayList<Reservation> listAll();
	int count();
	
}
