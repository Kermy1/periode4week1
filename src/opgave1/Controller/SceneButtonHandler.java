package opgave1.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import opgave1.View.GraphView;
import opgave1.View.TextView;

public class SceneButtonHandler implements EventHandler<ActionEvent> {
	private final Stage primaryStage;
	private TextView tView;
	private GraphView gView;

	public SceneButtonHandler(Stage primaryStage, TextView tView, GraphView gView) {
		this.primaryStage = primaryStage;
		this.tView = tView;
		this.gView = gView;
		tView.registerEventHandler(this);
		gView.registerEventHandler(this);
	}

	@Override
	public void handle(ActionEvent e) {
		if(e.getSource()==tView.getButton()){
			System.out.println("to graph button");
			Scene s = gView.getScene();
			if(s!=null){
				primaryStage.setScene(s);
			}else{
				primaryStage.setScene(new Scene(gView, 600, 400));
			}
		}else if(e.getSource()==gView.getButton()){
			System.out.println("to text button");
			Scene s = tView.getScene();
			if(s!=null){
				primaryStage.setScene(s);
			}else{
				primaryStage.setScene(new Scene(tView, 600, 400));
			}
		}
	}

}
