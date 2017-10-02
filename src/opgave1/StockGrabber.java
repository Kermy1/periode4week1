package opgave1;
import java.util.ArrayList;
import java.util.HashMap;

public class StockGrabber implements Subject{
    private HashMap<Stock, ArrayList<Observer>> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    public StockGrabber(){
        // a list to hold all observers
        observers = new HashMap<Stock, ArrayList<Observer>>();
    }

    public void register(Stock priceType, Observer newObserver) {
    	ArrayList<Observer> observerList;
    	if((observerList = observers.get(priceType))!=null){
    		observerList.add(newObserver);
    	}else{
    		observerList = new ArrayList<Observer>();
    		observerList.add(newObserver);
    		observers.put(priceType, observerList);
    	}
    }

    public void unregister(Observer newObserver) {
        // TODO
    }

    public void notifyObserver(Stock stockType) {
        for(Observer observer : observers.get(stockType)){
        	switch(stockType){
				case IBM:
					observer.update(ibmPrice);
					break;
				case AAPL:
					observer.update(aaplPrice);
					break;
				case GOOG:
					observer.update(googPrice);
					break;
			}
        }
    }

    public void setIBMPrice(double newIBMPrice){

        this.ibmPrice = newIBMPrice;
        notifyObserver(Stock.IBM);

    }

    public void setAAPLPrice(double newAAPLPrice){

        this.aaplPrice = newAAPLPrice;
        notifyObserver(Stock.AAPL);
    }

    public void setGOOGPrice(double newGOOGPrice){

        this.googPrice = newGOOGPrice;
        notifyObserver(Stock.GOOG);
    }
}
