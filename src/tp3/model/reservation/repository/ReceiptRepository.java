package tp3.model.reservation.repository;

import java.util.ArrayList;

import tp3.model.reservation.receipt.ReceiptBuilder;

public interface ReceiptRepository {
	
	public void add(ReceiptBuilder receipt);
	public ArrayList<ReceiptBuilder> listAll();
	int count();
	
}
