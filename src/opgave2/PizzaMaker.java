package opgave2;
// the CLient
public class PizzaMaker {

    public static void main(String[] args){
        // create a basic pizza with mozzarella & tomatosauce

        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
        //basicPizza.setSize("medium");
        System.out.println("Ingredients: " + basicPizza.getDescription());
        System.out.println("Price: " + basicPizza.getCost());

    }

}