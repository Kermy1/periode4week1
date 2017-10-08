package opgave1.Model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import opgave1.Controller.SceneButtonHandler;
import opgave1.View.GraphView;
import opgave1.View.MyChart;
import opgave1.View.TextView;
import opgave1.View.View;

// the Client
public class StockApp extends Application{
    public static void main(String[] args){
		launch(args);
		//Application.launch(MyChart.class, args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		//subject
    	StockGrabber subject = new StockGrabber();

    	//views
    	GraphView graphView = new GraphView();
    	TextView textView = new TextView();

    	//controller
    	SceneButtonHandler controller = new SceneButtonHandler(primaryStage, textView, graphView);

		//observers
		StockObserver ob1 = new StockObserver(Stock.IBM, subject);
		ob1.registerView(textView);
		ob1.registerView(graphView);
		StockObserver ob2 = new StockObserver(Stock.AAPL, subject);
		ob2.registerView(textView);
		ob2.registerView(graphView);
		StockObserver ob3 = new StockObserver(Stock.GOOG, subject);
		ob3.registerView(textView);
		ob3.registerView(graphView);

		//threads
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(new GetTheStock(Stock.IBM, 50, subject));
		executor.execute(new GetTheStock(Stock.AAPL, 50, subject));
		executor.execute(new GetTheStock(Stock.GOOG, 50, subject));



		//javafx
		primaryStage.setScene(new Scene(textView, 600, 400));

		primaryStage.show();

	}
}

