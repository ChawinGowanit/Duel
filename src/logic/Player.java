package logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private String name;
	private int num;
	private HashMap<String, Integer> resourceCounter;
	private HashMap<String, Integer> buyResourceCost;
	private ArrayList<String> chainSymbols;
	private int playerPoint;
	private int attackPoint;
	
	public Player(String name, int num) {
		this.name = name;
		this.num = num;
		this.resourceCounter = new HashMap<String, Integer>();
		this.resourceCounter.put("D32Steel", 0);
		this.resourceCounter.put("Bipolar Nanoflake", 0);
		this.resourceCounter.put("Polymerization Preparation", 0);
		this.resourceCounter.put("Sugar Pack", 0);
		this.resourceCounter.put("Manganese Ore", 0);
		this.resourceCounter.put("LMD", 7);
		this.buyResourceCost = new HashMap<String, Integer>();
		this.buyResourceCost.put("D32SteelCost", 2);
		this.buyResourceCost.put("NanoflakeCost", 2);
		this.buyResourceCost.put("PolymerizationCost", 2);
		this.buyResourceCost.put("SugarPackCost", 2);
		this.buyResourceCost.put("ManganeseCost", 2);
		this.chainSymbols = new ArrayList<String>();
		this.playerPoint = 0;
		this.attackPoint = 0;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNum(int num) {
		this.num = num;
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

	public void setChainSymbol(ArrayList<String> chainSymbols) {
		this.chainSymbols = chainSymbols;
	}

	public String getName() {
		return this.name;
	}

	public int getNum() {
		return this.num;
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

	public void increaseResourceCounter(String key, int counter) {
		this.resourceCounter.put(key, this.resourceCounter.get(key) + counter);
	}

	public void increasePlayerPoint(int point) {
		this.playerPoint += point;
	}

	public void addChainSymbol(String chainSymbol) {
		this.chainSymbols.add(chainSymbol);
	}
	
	
	public Player getPlayer(Player ATKplayer,Player player) {
		if (ATKplayer.getNum() == 1) {
			return player ;
		} else {
			return ATKplayer ;
		}
	}
}
