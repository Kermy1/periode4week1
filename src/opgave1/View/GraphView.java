package opgave1.View;

import java.util.HashMap;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import opgave1.Controller.SceneButtonHandler;
import opgave1.Model.Stock;

public class GraphView extends StackPane implements View{
	private Button btn;
	private int currentXAxisValue = 0;
	private LineChart linechart;
	private HashMap<Stock, XYChart.Series> stockSeries;
	public GraphView(){
		// defining the x&y axis
        NumberAxis xAxis = new NumberAxis(0, 100, 1);
        xAxis.setLabel("Time");
        NumberAxis yAxis = new NumberAxis(49.5, 50.5, 0.1);
        yAxis.setLabel("Price");

        // creating the line chart
        linechart = new LineChart(xAxis, yAxis);
        linechart.setTitle("Stock price chart");

		btn = new Button("Text view");
		getChildren().add(linechart);
		setAlignment(btn, Pos.BOTTOM_RIGHT);
		getChildren().add(btn);

		stockSeries = new HashMap<Stock, XYChart.Series>();
	}

	@Override
	public void update(Stock stockType, double price) {
		if(!stockSeries.containsKey(stockType)){
			XYChart.Series s = new XYChart.Series();
	        s.setName(stockType+"");
	        linechart.getData().add(s);
			stockSeries.put(stockType, s);
		}
		XYChart.Series series = stockSeries.get(stockType);
		series.getData().add(new XYChart.Data(currentXAxisValue++, price));
	}

	@Override
	public void registerEventHandler(EventHandler handler) {
		btn.setOnAction(handler);
	}

	public Button getButton(){
		return btn;
	}
}
