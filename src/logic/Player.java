package logic;

import java.util.HashMap;

public class Player {
	private String name;
	private HashMap<String, Integer> resourceCounter;
	private HashMap<String, Integer> buyResourceCost;
	private int playerPoint;
	private int attackPoint;

	Player(HashMap<String, Integer> resourceCounter, HashMap<String, Integer> buyResourceCost) {
		this.resourceCounter = resourceCounter;
		this.buyResourceCost = buyResourceCost;
		this.playerPoint = 0;
		this.attackPoint = 0;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResourceCounter(HashMap<String, Integer> resourceCounter) {
		this.resourceCounter = resourceCounter;
	}

	public void setBuyResourceCost(HashMap<String, Integer> buyResourceCost) {
		this.buyResourceCost = buyResourceCost;
	}

	public void setPlayerPoint(int playerPoint) {
		this.playerPoint = playerPoint;
	}

	public void setAttackPoint(int attackPoint) {
		this.attackPoint = attackPoint;
	}

	public String getName() {
		return this.name;
	}

	public HashMap<String, Integer> getResourceCounter() {
		return this.resourceCounter;
	}

	public HashMap<String, Integer> getbuyResourceCost() {
		return this.buyResourceCost;
	}

	public int getplayerPoint() {
		return this.playerPoint;
	}

	public int getAttackpoint() {
		return this.attackPoint;
	}
}
