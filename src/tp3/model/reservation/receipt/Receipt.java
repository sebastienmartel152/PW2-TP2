package tp3.model.reservation.receipt;

import tp3.model.reservation.Reservation;
import tp3.model.reservation.customer.Customer;
import tp3.view.DTO.DTOSelectedDate;

public class Receipt {
	
	private Reservation reservation;
	private Customer customer;
	private DTOSelectedDate date;
	
	public Receipt(Customer customer, Reservation reservation, DTOSelectedDate date){
		this.reservation = reservation;
		this.customer = customer;
		this.date = date;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	public Reservation getReservation(){
		return this.reservation;
	}
	
	public DTOSelectedDate getDate(){
		return this.date;
	}

}