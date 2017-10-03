package opgave1.Model;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable {
	private Stock stockType;
	private double stockPrice;
	private StockGrabber stockGrabber;

	public GetTheStock(Stock stockType, double stockPrice, StockGrabber stockGrabber) {
		this.stockType = stockType;
		this.stockPrice = stockPrice;
		this.stockGrabber = stockGrabber;
		System.out.println(stockType);
	}

	@Override
	public void run() {
		while(true){
			try {
				double randNum = (Math.random() * (.1)) - .05;
				DecimalFormat df = new DecimalFormat("#.##");
				stockPrice = Double.valueOf(df.format((stockPrice + randNum)));
				switch(stockType){
					case IBM:
						stockGrabber.setIBMPrice(stockPrice);
						break;
					case AAPL:
						stockGrabber.setAAPLPrice(stockPrice);
						break;
					case GOOG:
						stockGrabber.setGOOGPrice(stockPrice);
						break;
				}
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
