package opgave2;
// a Concrete Decorator
public class Mozzarella extends ToppingDecorator {

    public Mozzarella(Pizza newPizza) {

        super(newPizza);
        System.out.println("Adding Mozzarella");
    }

    public String getDescription(){

        return tempPizza.getDescription() + ", mozzarella";
    }

    public double getCost(){
    	double cost = .50;
    	switch(tempPizza.getSize()){
	    	case "large":
	    		cost = cost*1.1;
	    		break;
	    	case "medium":
	    		cost = cost*1;
	    		break;
	    	case "small":
	    		cost = cost*0.9;
	    		break;
		}
    	System.out.println("Cost of mozzarella: " + cost);
        return tempPizza.getCost() + cost;
    }

	@Override
	public String getSize() {
		return tempPizza.getSize();
	}

	@Override
	public void setSize(String size) {
		tempPizza.setSize(size);
	}
}
