package tp3.model.reservation;

public class Receipt { //@SM: code mort. Classe non utilisée
	
	private Customer customer;
	private Reservation reservation;
	private String date;
	
	public Receipt(Customer customer, Reservation reservation, String date){
		
		this.customer = customer;
		this.reservation = reservation;
		this.date = date;
	}

}
