package tp3.model.reservation.repository;

import java.util.ArrayList;
import java.util.Collection;

import tp3.model.reservation.receipt.ReceiptBuilder;



public class ReceiptMemoryRepository implements ReceiptRepository {
	
	private Collection<ReceiptBuilder> receipts = new ArrayList<ReceiptBuilder>();
	
	@Override
	public void add(ReceiptBuilder receipt) {
		this.receipts.add(receipt);
		
	}

	@Override
	public ArrayList<ReceiptBuilder> listAll() {
		return new ArrayList<ReceiptBuilder>(this.receipts);
	}

	@Override
	public int count() {
		return this.receipts.size();
	}

}
