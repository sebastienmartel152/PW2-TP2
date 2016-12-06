package tp3.model.reservation;

public enum CottageType {
	FOURPERSON("Chalet 4 personnes", 4), SIXPERSON("Chalet 6 personnes", 6), TENPERSON("Chalet 10 personnes", 10);
	
	private String text;
	private int maxNumberOfPeople;
	
	private CottageType(String text, int maxNumberOfPeople){
		this.text = text;
		this.maxNumberOfPeople = maxNumberOfPeople;
	}
	
	public int getMaxNumberOfPeople(){
		return this.maxNumberOfPeople;
	}
	
	@Override
	public String toString(){
		return this.text;
	}
}
