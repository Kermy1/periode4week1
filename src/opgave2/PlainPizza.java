package opgave2;
// a Concrete Component
public class PlainPizza implements Pizza {
	private String size = "medium";
    public String getDescription() {
        return "Just a "+size+" plain pizza";
    }

    public double getCost() {
    	double cost = 4.00;
    	switch(size){
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

        System.out.println("Cost of a plain "+size+" pizza: " + cost);
        return cost;
    }

	@Override
	public String getSize() {
		return size;
	}

	@Override
	public void setSize(String size) {
		this.size = size;

	}
}
