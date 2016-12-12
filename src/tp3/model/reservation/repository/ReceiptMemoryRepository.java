package tp3.model.reservation.repository;

import java.util.ArrayList;
import java.util.Collection;

import tp3.model.reservation.Reservation;
import tp3.model.reservation.receipt.Receipt;

public class ReceiptMemoryRepository implements ReceiptRepository {
	
	private Collection<Receipt> receipts = new ArrayList<Receipt>();
	
	@Override
	public void add(Receipt receipt) {
		this.receipts.add(receipt);
		
	}

	@Override
	public ArrayList<Receipt> listAll() {
		return new ArrayList<Receipt>(this.receipts);
	}

	@Override
	public int count() {
		return this.receipts.size();
	}

}
