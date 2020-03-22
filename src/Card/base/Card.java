package Card.base;

import java.util.HashMap;
import java.util.Arrays;

public abstract class Card {
	private String name;
	private String image;
	private String type;
	private int age;
	private int[] position;
	private boolean pickAble;
	private boolean flipAble;
	private boolean isFlip;
	private HashMap<String, Integer> cost;

	public Card(String name, String image, String type, int age, int[] position, boolean pickAble, boolean flipAble,
			boolean isFlip, HashMap<String, Integer> cost) {
		this.name = name;
		this.image = image;
		this.type = type;
		this.age = age;
		this.position = position;
		this.pickAble = pickAble;
		this.flipAble = flipAble;
		this.isFlip = false;
		this.cost = cost;
	}

	public void filp(boolean flipAble) {
		if (flipAble) {
			this.isFlip = true;
		}
	}

	public String getName() {
		return this.name;
	}

	public String image() {
		return this.image;
	}
	public HashMap<String, Integer> getCost(){
		return this.cost ;
	}
}
