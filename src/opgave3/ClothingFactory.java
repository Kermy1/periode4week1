package opgave3;

public class ClothingFactory {
	public static Clothing getClothing(String clothingName){
		Clothing clothing = null;
		switch(clothingName){
			case "blue T-shirt":
				clothing = new TShirt("blue");
				break;
			case "green T-shirt":
				clothing = new TShirt("green");
				break;
			case "red T-shirt":
				clothing = new TShirt("red");
				break;
			case "jeans":
				clothing = new Jeans();
				break;
		}
		return clothing;
	}

}
