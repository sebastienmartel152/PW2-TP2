package tp3.view.DTO;

public enum Months {
	JANUARY("Janvier", 31), FEBRUARY("Février", 28), MARCH("Mars", 31), APRIL("Avril", 30),
	MAY("Mai", 31), JUNE("Juin", 30), JULY("Juillet", 31), AUGUST("Août", 31),
	SEPTEMBER("Septembre", 30), OCTOBER("Octobre", 31), NOVEMBER("Novembre", 30), DECEMBER("Décembre", 31);
	
	private String monthName;
	private int maxNbDays;
	
	private Months(String monthName, int maxNbDays){
		this.monthName = monthName;
		this.maxNbDays = maxNbDays;
	}
	
	public String toString(){
		return this.monthName;
	}
	
	public int getMaxNbDays(){
		return this.maxNbDays;
	}
}
