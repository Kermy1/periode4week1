package opgave3;

public class TShirt implements Clothing {
	private String colour;
	public TShirt(String colour) {
		this.colour = colour;
	}

	@Override
	public String getDescription() {
		return "a "+colour+" T-shirt";
	}

}
