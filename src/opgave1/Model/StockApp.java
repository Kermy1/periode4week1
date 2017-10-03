package opgave1.Model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import opgave1.View.TextView;

// the Client
public class StockApp{
    public static void main(String[] args){
		//subject
    	StockGrabber subject = new StockGrabber();

		//observers
		new StockObserver(Stock.IBM, subject);
		new StockObserver(Stock.AAPL, subject);
		new StockObserver(Stock.GOOG, subject);

		//views
		Application.launch(TextView.class, args);

		//threads
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(new GetTheStock(Stock.IBM, 50, subject));
		executor.execute(new GetTheStock(Stock.AAPL, 50, subject));
		executor.execute(new GetTheStock(Stock.GOOG, 50, subject));
    }
}

