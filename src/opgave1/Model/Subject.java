package opgave1.Model;
public interface Subject {

    public void register(Stock p, Observer o);
    public void unregister(Observer o);
    public void notifyObserver(Stock p);

}
