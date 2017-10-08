package opgave1.Model;

import java.util.ArrayList;

import javafx.application.Platform;
import opgave1.View.View;

public class StockObserver implements Observer {

    private double price;
    private Stock stockType;

    // static used as a counter
    private static int observerIDTracker = 0;

    // to track the observers
    private int observerID;

    // a reference to concrete subject
    private Subject stockGrabber;

    // a reference to the view
    private ArrayList<View> views;

    public StockObserver(Stock priceType, Subject stockGrabber){
     this.stockType = priceType;
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        stockGrabber.register(priceType, this);
        views = new ArrayList<View>();

        System.out.println("New Observer " + this.observerID);
    }

    // update all observers
    public void update(double price) {
        this.price = price;
        printThePrices();
        //update views
        for(View v : views){
        	Platform.runLater(()->v.update(stockType, price));
        }
    }

    public void registerView(View view){
    	views.add(view);
    }

    public void printThePrices(){

        System.out.println("Observer: " + observerID + "\n" + stockType + ": " + price + "\n");
    }
}
