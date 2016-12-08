package tp3.model.reservation.receipt;

import tp3.model.reservation.Reservation;
import tp3.model.reservation.customer.Customer;

public class Receipt {
	
	private Reservation reservation;
	private Customer customer;
	private String date;
	
	public Receipt(){
		this.reservation = reservation;
		this.customer = customer;
		this.date = date;
	}

}
