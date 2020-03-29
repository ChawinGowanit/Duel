package Card.base;


public abstract class Card {
	private String name;
	private Cost cost;
	private int position;
	private boolean flipAble;
	private boolean pickAble;

	public Card(String name, Cost cost) {
		this.name = name;
		this.cost = cost;
		this.flipAble = false;
		this.pickAble = false;

	}

	public String getName() {
		return this.name;
	}

	public Cost getCost() {
		return this.cost;
	}

	public boolean isPickAble() {
		return this.pickAble;
	}
	public void setPosition(int position) {
		this.position = position ;
	}
	public int getPosition() {
		return this.position ;
	}
	public String toString() {
		return this.name+" "+this.pickAble;
	}
	
	public void setFlipAble(boolean flipAble) {
		this.flipAble= flipAble;
	}
	public void setPickAble(boolean pickAble) {
		this.pickAble = pickAble;
	}
	public boolean isFlipAble() {
		return flipAble;
	}
		
	
}
