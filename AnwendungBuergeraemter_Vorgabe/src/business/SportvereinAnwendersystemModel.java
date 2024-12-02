package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import fabrik.ConcreteCreator;
import fabrik.Creator;
import fabrik.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class SportvereinAnwendersystemModel implements Observable{
	
	Vector<Observer> observers = new Vector<Observer>();
	
	private static SportvereinAnwendersystemModel anwendersystemModel;
	
	public static SportvereinAnwendersystemModel getInstance() {
		if(anwendersystemModel == null) {
			
			anwendersystemModel = new SportvereinAnwendersystemModel();
			
		}
		return anwendersystemModel;
	}
	
	private Sportverein sportverein;

	public Sportverein getSportverein() {
		return sportverein;
	}

	public void setSportverein(Sportverein sportverein) {
		this.sportverein = sportverein;
		notifyObservers();
	}

	private SportvereinAnwendersystemModel() {
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
	      			notifyObservers();
	  }
	 
	 
	 
	 public void schreibeSportvereinInCsvDatei() throws IOException {
		
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("SportveienAusgabe.csv", true));
				aus.write(sportverein.gibSportvereinZurueck(';'));
				aus.close();
				
				
	 }

	@Override
	public void addObserver(Observer obs) {
		this.observers.addElement(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.removeElement(obs);
		
	}

	@Override
	public void notifyObservers() {
		for(int i = 0; i< observers.size(); i++) {
			this.observers.elementAt(i).update();
		}
		
	}

}
