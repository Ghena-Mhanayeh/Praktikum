package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fabrik.ConcreteCreator;
import fabrik.Creator;
import fabrik.Product;

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
	
	 public void leseAusDatei(String typ)throws IOException{
		 
	      			Creator creator = new ConcreteCreator();
	      			Product reader = creator.fabricMethod(typ);
	      			String [] zeile = reader.leseAusDatei();
	      			this.sportverein = new Sportverein(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				Float.parseFloat(zeile[2]), 
	      				zeile[3], zeile[4].split("_"));
		
	  }
	 
	 
	 
	 public void schreibeSportvereinInCsvDatei() throws IOException {
		
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("SportveienAusgabe.csv", true));
				aus.write(sportverein.gibSportvereinZurueck(';'));
				aus.close();
				
				
	 }

}
