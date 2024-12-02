package gui.sportverein;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Sportverein;
import business.SportvereinAnwendersystemModel;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;

public class SportvereinAnwendersystemControl implements Observer{
	
	SportvereinAnwendersystemModel anwModel;
	SportvereinAnwendersystemView anwView;
	
	
	public SportvereinAnwendersystemControl(Stage primaryStage) {
		this.anwModel = SportvereinAnwendersystemModel.getInstance(); 	
		this.anwView = new SportvereinAnwendersystemView(this, primaryStage, anwModel);
		anwModel.addObserver(this);
	}
	
	 public void leseAusDatei(String typ){
	    	try {
	      		if("csv".equals(typ)){
	      			anwModel.leseAusDatei("csv");
	      	  		anwView.zeigeInformationsfensterAn(
	      	  	   			"Die Sportverein wurden gelesen!");
	      		}
	       		else{
	       			anwModel.leseAusDatei("txt");
	      	  		anwView.zeigeInformationsfensterAn(
	      	  	   			"Die Sportverein wurden gelesen!");
		   		}
			}
			catch(IOException exc){
				anwView.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				anwView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}
	 
	 
	 public void schreibeSportvereinInCsvDatei() {
			try {
				anwModel.schreibeSportvereinInCsvDatei();
	   			anwView.zeigeInformationsfensterAn(
		   			"Die Sportverein wurden gespeichert!");
			}	
			catch(IOException exc){
				anwView.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
			}
			catch(Exception exc){
				anwView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Speichern!");
			}
		}

	    public void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	    		"Information", meldung).zeigeMeldungsfensterAn();
	    }	
	    
	    void zeigeFehlermeldungsfensterAn(String meldung){
	       	new MeldungsfensterAnzeiger(AlertType.ERROR,
	        	"Fehler", meldung).zeigeMeldungsfensterAn();
	    }

		@Override
		public void update() {
			this.anwView.zeigeSportvereinAn();
			
		}

}
