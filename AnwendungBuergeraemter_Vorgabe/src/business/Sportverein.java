package business;

public class Sportverein {
	
	// Name des Buergeramtes
    private String name;
    // Oeffnungszeiten
    private float anzahlMitglieder;
    private float anzahlehrMitglieder;
    // Strasse und Hausnummer des Buergeramtes
    private String ort;
    // Dienstleistungen des Buergeramtes
    private String[] sportarten;

    public Sportverein(String name, float anzahlMitglieder, float anzahlehrMitglieder, String ort,
			String[] sportarten) {
		super();
		this.name = name;
		this.anzahlMitglieder = anzahlMitglieder;
		this.anzahlehrMitglieder = anzahlehrMitglieder;
		this.ort = ort;
		this.sportarten = sportarten;
	}

	
    
	
	
	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public float getAnzahlMitglieder() {
		return anzahlMitglieder;
	}





	public void setAnzahlMitglieder(float anzahlMitglieder) {
		this.anzahlMitglieder = anzahlMitglieder;
	}





	public float getAnzahlehrMitglieder() {
		return anzahlehrMitglieder;
	}





	public void setAnzahlehrMitglieder(float anzahlehrMitglieder) {
		this.anzahlehrMitglieder = anzahlehrMitglieder;
	}





	public String getOrt() {
		return ort;
	}





	public void setOrt(String ort) {
		this.ort = ort;
	}





	public String[] getSportarten() {
		return sportarten;
	}





	public void setSportarten(String[] sportarten) {
		this.sportarten = sportarten;
	}





	public String getSportartenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getSportarten().length - 1; i++) {
			ergebnis = ergebnis + this.getSportarten()[i] + trenner; 
		}
		return ergebnis	+ this.getSportarten()[i];
	}
	
	public String gibSportvereinZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getAnzahlMitglieder() + trenner
  		    + this.getAnzahlehrMitglieder() + trenner
  		    + this.getOrt() + trenner + "\n"
  		    + this.getSportartenAlsString(trenner) + "\n";
  	}
}

