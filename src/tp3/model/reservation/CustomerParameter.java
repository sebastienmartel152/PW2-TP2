package tp3.model.reservation;

public class CustomerParameter {
	private String name;
	private String address;
	private String phone;
	private String mail;

	public CustomerParameter(String name, String address, String phone, String mail) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}