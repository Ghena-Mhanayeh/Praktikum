package main;

import gui.SportvereinAnwendersystemControl;
import gui.SportvereinAnwendersystemView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new SportvereinAnwendersystemControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
