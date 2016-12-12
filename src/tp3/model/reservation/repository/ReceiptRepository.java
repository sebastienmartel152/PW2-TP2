package tp3.model.reservation.repository;

import java.util.ArrayList;

import tp3.model.reservation.Reservation;
import tp3.model.reservation.receipt.Receipt;


public interface ReceiptRepository {
	
	public void add(Receipt receipt);
	public ArrayList<Receipt> listAll();
	int count();
	
}
