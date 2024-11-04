package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SportvereinAnwendersystemModel {
	
	   private Sportverein sportverein;

	public Sportverein getSportverein() {
		return sportverein;
	}

	public void setSportverein(Sportverein sportverein) {
		this.sportverein = sportverein;
	}

	public SportvereinAnwendersystemModel() {
		super();
	}
	
	 public void leseAusDatei()throws IOException{

	      			BufferedReader ein = new BufferedReader(new FileReader("Sportverein.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.sportverein = new Sportverein(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				Float.parseFloat(zeile[2]), 
	      				zeile[3], zeile[4].split("_"));
	      				ein.close();
	  }
	 
	 public void schreibeSportvereinInCsvDatei() throws IOException {
		
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("SportveienAusgabe.csv", true));
				aus.write(sportverein.gibSportvereinZurueck(';'));
				aus.close();
				
				
	 }

}
