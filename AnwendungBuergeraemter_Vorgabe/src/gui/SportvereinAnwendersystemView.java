package gui;
   
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Sportverein;
import business.SportvereinAnwendersystemModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class SportvereinAnwendersystemView {
	
	SportvereinAnwendersystemControl anwControl;
	SportvereinAnwendersystemModel anwModel;
	  
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblAnzahlMitglieder   	= new Label("Anzahl Mitgleider:");
    private Label lblAnzahlehrMitglieder  	= new Label("Anzahl ehemaliger Mitglieder:");
    private Label lblOrt   					= new Label("Ort:");
    private Label lblSportarten  			= new Label("Sportarten:");
    private TextField txtName 	 			= new TextField();
    private TextField txtAnzahlMitglieder	= new TextField();
    private TextField txtAnzahlehrMitglieder= new TextField();
    private TextField txtOrt			= new TextField();
    private TextField txtSportarten	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Buergeramt
 
    
    public SportvereinAnwendersystemView(SportvereinAnwendersystemControl anwControl ,Stage primaryStage, SportvereinAnwendersystemModel anwModel){
    	
    	this.anwControl = anwControl;
    	this.anwModel = anwModel;
    	
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Sportverein");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblAnzahlMitglieder.setLayoutX(20);
    	lblAnzahlMitglieder.setLayoutY(130);
    	lblAnzahlehrMitglieder.setLayoutX(20);
    	lblAnzahlehrMitglieder.setLayoutY(170);
    	lblOrt.setLayoutX(20);
    	lblOrt.setLayoutY(210);
    	lblSportarten.setLayoutX(20);
    	lblSportarten.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblAnzahlMitglieder, lblAnzahlehrMitglieder,
       		lblOrt, lblSportarten);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtAnzahlMitglieder.setLayoutX(170);
    	txtAnzahlMitglieder.setLayoutY(130);
    	txtAnzahlMitglieder.setPrefWidth(200);
    	txtAnzahlehrMitglieder.setLayoutX(170);
    	txtAnzahlehrMitglieder.setLayoutY(170);
    	txtAnzahlehrMitglieder.setPrefWidth(200);
      	txtOrt.setLayoutX(170);
    	txtOrt.setLayoutY(210);
    	txtOrt.setPrefWidth(200);
    	txtSportarten.setLayoutX(170);
    	txtSportarten.setLayoutY(250);
    	txtSportarten.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtAnzahlMitglieder, txtAnzahlehrMitglieder,
     		txtOrt, txtSportarten);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    nehmeSportvereinauf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeSportvereinAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeSportvereinInCsvDatei();
			}	
	    });
    }
    
    private void nehmeSportvereinauf(){
    	try{
    		anwModel.setSportverein(new Sportverein(
    			txtName.getText(), 
   	            Float.parseFloat(txtAnzahlMitglieder.getText()),
   	            Float.parseFloat(txtAnzahlehrMitglieder.getText()),
    		    txtOrt.getText(),
    		    txtSportarten.getText().split(";")));
    		zeigeInformationsfensterAn("Das Sportverein wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    private void zeigeSportvereinAn(){
    	if(anwModel.getSportverein() != null){
    		txtAnzeige.setText(
    			anwModel.getSportverein().gibSportvereinZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Sportverein aufgenommen!");
    	}
    }    
		  
    private void leseAusDatei(String typ){
    	anwControl.leseAusDatei(typ);
	}
		
	private void schreibeSportvereinInCsvDatei() {
		anwControl.schreibeSportvereinInCsvDatei();
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
