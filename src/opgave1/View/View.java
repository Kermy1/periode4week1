package opgave1.View;

import javafx.event.EventHandler;
import opgave1.Model.Stock;

public interface View {
	public void update(Stock stockType, double price);
	public void registerEventHandler(EventHandler handler);
}
