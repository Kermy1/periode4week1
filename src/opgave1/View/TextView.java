package opgave1.View;

import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import opgave1.Controller.SceneButtonHandler;
import opgave1.Model.Stock;

public class TextView extends StackPane implements View{
	private HashMap<Stock, String> stockFields;
	private ListView<String> list;
	private Button btn;

	public TextView(){
		stockFields = new HashMap<Stock, String>();
		list = new ListView<String>();
		btn = new Button("Graph view");
		getChildren().add(list);
		setAlignment(btn, Pos.BOTTOM_RIGHT);
		getChildren().add(btn);
	}

	@Override
	public void update(Stock stockType, double price) {
		stockFields.put(stockType, stockType+": "+price);

		list.getItems().clear();
		for(Map.Entry<Stock, String> entry : stockFields.entrySet()) {
			Stock key = entry.getKey();
			String value = entry.getValue();

			list.getItems().add(value);
		}
	}

	@Override
	public void registerEventHandler(EventHandler handler) {
		btn.setOnAction(handler);
	}

	public Button getButton(){
		return btn;
	}
}
