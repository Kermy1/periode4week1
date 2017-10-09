package opgave3;

import java.util.LinkedList;
import java.util.Queue;

public class Person implements Runnable {
	private LinkedList<String> clothingSequence;
	public Person() {
		clothingSequence = new LinkedList<String>();
		clothingSequence.push("red T-shirt");
		clothingSequence.push("blue T-shirt");
		clothingSequence.push("jeans");
		clothingSequence.push("green T-shirt");
		clothingSequence.push("red T-shirt");
	}

	@Override
	public void run() {
		while(clothingSequence.size()>0){
			try {
				Clothing newClothing = ClothingFactory.getClothing(clothingSequence.pop());
				System.out.println(newClothing.getDescription());
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
