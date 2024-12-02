package main;

import freizeitAngebote.FreizeitangeboteControl;
import gui.sportverein.SportvereinAnwendersystemControl;
import gui.sportverein.SportvereinAnwendersystemView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new SportvereinAnwendersystemControl(primaryStage);
		Stage fensterFreizeitangebote = new Stage();
		new FreizeitangeboteControl(fensterFreizeitangebote);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
