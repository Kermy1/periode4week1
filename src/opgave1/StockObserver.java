package opgave1;
public class StockObserver implements Observer {
    
    private double price;
    private Stock stockType;
    
    // static used as a counter
    private static int observerIDTracker = 0;
    
    // to track the observers
    private int observerID;
    
    // a reference to concrete subject
    private Subject stockGrabber;
    
    public StockObserver(Stock priceType, Subject stockGrabber){
     this.stockType = priceType;
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        stockGrabber.register(priceType, this);

        System.out.println("New Observer " + this.observerID);
    }
    
    // update all observers
    public void update(double price) {
        
        this.price = price;
        printThePrices();
    }
    
    public void printThePrices(){
        
        System.out.println(observerID + "\n" + stockType + ": " + price + "\n");
    }
}
