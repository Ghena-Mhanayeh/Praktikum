package freizeitAngebote;

import business.SportvereinAnwendersystemModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class FreizeitangeboteControl implements Observer {
	private SportvereinAnwendersystemModel sportvereineModel;
	private FreizeitangeboteView freizeitangeboteView;
	
	public FreizeitangeboteControl(Stage primaryStage){
		this.sportvereineModel = SportvereinAnwendersystemModel.getInstance(); 		
		this.freizeitangeboteView = new FreizeitangeboteView(this, primaryStage,sportvereineModel);
		sportvereineModel.addObserver(this);
}
@Override
	public void update() {
		this.freizeitangeboteView.zeigeSportvereineAn();		
	}

}
