package Card.base;

import java.util.HashMap;

public abstract class Card {
	private String name;
	private int position;
	private boolean flipAble;
	private boolean isFlip;
	private boolean pickAble;
	private HashMap<String,Integer> cost;
	
	public Card(String name,HashMap<String,Integer> cost) {
		this.name = name;	
		this.cost = cost;
		this.flipAble = false;
		this.isFlip = false;
		this.pickAble = false ;
		
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
