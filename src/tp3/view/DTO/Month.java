package tp3.view.DTO;

public enum Month {
	JANUARY("Janvier", 31, 1), FEBRUARY("Février", 28, 2), MARCH("Mars", 31, 3), APRIL("Avril", 30, 4),
	MAY("Mai", 31, 5), JUNE("Juin", 30, 6), JULY("Juillet", 31, 7), AUGUST("Août", 31, 8),
	SEPTEMBER("Septembre", 30, 9), OCTOBER("Octobre", 31, 10), NOVEMBER("Novembre", 30, 11), DECEMBER("Décembre", 31, 12);
	
	private String monthName;
	private int maxNbDays;
	private int numericValue;
	
	private Month(String monthName, int maxNbDays, int numericValue){
		this.monthName = monthName;
		this.maxNbDays = maxNbDays;
		this.numericValue = numericValue;
	}
	
	public String toString(){
		return this.monthName;
	}
	
	public int getMaxNbDays(){
		return this.maxNbDays;
	}
	
	public int getNumericValue(){
		return this.numericValue;
	}
}
