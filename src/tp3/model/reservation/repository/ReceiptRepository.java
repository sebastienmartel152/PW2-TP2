package tp3.model.reservation.repository;

import java.util.ArrayList;


import tp3.model.reservation.Receipt;
import tp3.model.reservation.Reservation;




public interface ReceiptRepository {
	
	public void add(Receipt receipt);
	public ArrayList<Receipt> listAll();
	int count();
	
}
