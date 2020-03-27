package Card.base;


public abstract class Card {
	private String name;
	private Cost cost;
	private int position;
	private boolean flipAble;
	private boolean isFlip;
	private boolean pickAble;

	public Card(String name, Cost cost) {
		this.name = name;
		this.cost = new Cost();
		this.flipAble = false;
		this.isFlip = false;
		this.pickAble = false;

	}

	public String getName() {
		return this.name;
	}

	public Cost getCost() {
		return this.cost;
	}

	public boolean getPickAble() {
		return this.pickAble;
	}
	public void setPosition(int position) {
		this.position = position ;
	}
	public int getPosition() {
		return this.position ;
	}
	public String toString() {
		return this.name ;
	}
	
	public void setFlipAble(boolean flipAble) {
		this.flipAble= flipAble;
	}
	
	
		
	
}
