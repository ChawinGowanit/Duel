package Card.base;

import java.util.HashMap;

public abstract class Card {
	private String name;
	private String type;
	private int age;
	private int[] position;
	private boolean flipAble;
	private boolean isFlip;
	private HashMap<String,Integer> cost;
	
	public Card(String name,String type,int age,HashMap<String,Integer> cost) {
		this.name = name;
		this.type = type;
		this.age = age;
		this.cost = cost;
		this.flipAble = false;
		this.isFlip = false;
		
	}
	
	
	public String getName() {
		return this.name;
	}

	
	public HashMap<String ,Integer> getCost(){
		return this.cost ;
	}
	public boolean getPickAble() {
		return this.pickAble ;
	}
}
