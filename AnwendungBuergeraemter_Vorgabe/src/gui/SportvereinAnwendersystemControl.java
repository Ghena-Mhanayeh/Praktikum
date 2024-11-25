package gui;

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

public class SportvereinAnwendersystemControl {
	
	SportvereinAnwendersystemModel anwModel;
	SportvereinAnwendersystemView anwView;
	
	
	public SportvereinAnwendersystemControl(Stage primaryStage) {
		this.anwModel = new SportvereinAnwendersystemModel();
		this.anwView = new SportvereinAnwendersystemView(this, primaryStage, anwModel);
		
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

}
