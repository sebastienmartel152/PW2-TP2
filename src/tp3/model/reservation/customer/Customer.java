
package tp3.model.reservation.customer;

public class Customer {
	
	private String name;
	private String address;
	private String phone;
	private String mail;
	
	public Customer(String name, String address, String phone, String mail){
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getMail(){
		return this.mail;
	}
	

}