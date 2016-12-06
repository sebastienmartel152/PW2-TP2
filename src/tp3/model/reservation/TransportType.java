package tp3.model.reservation;

public enum TransportType {
	BOAT("Bateau"), HYDROPLANE("Hydravion");
	
	private String text;
	
	private TransportType(String text){
		this.text = text;
	}
	
	@Override
	public String toString(){
		return this.text;
	}
}
