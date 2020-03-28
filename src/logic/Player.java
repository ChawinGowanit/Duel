package logic;


import Card.base.ChainSymbols;
import Card.base.Cost;

public class Player {
	private String name;
	private int num;
	private Cost resourceCounter;
	private Cost buyResourceCost;
	private ChainSymbols chainSymbols;
	private int sellResourceGain ;
	private int playerPoint;
	
	public Player(int num) {
		this.num = num;
		this.resourceCounter = new Cost(0,0,0,0,0,7) ;
		this.buyResourceCost = new Cost(2,2,2,2,2,1) ;
		this.chainSymbols = new ChainSymbols() ;
		this.sellResourceGain = 2;
		this.playerPoint = 0;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public void setResourceCounter(Cost resourceCounter) {
		this.resourceCounter = resourceCounter;
	}

	public void setBuyResourceCost(Cost buyResourceCost) {
		this.buyResourceCost = buyResourceCost;
	}

	public void setPlayerPoint(int playerPoint) {
		this.playerPoint = playerPoint;
	}

	public void setChainSymbol(ChainSymbols chainSymbols) {
		this.chainSymbols = chainSymbols;
	}

	public String getName() {
		return this.name;
	}

	public int getNum() {
		return this.num;
	}

	public Cost getResourceCounter() {
		return this.resourceCounter;
	}

	public Cost getbuyResourceCost() {
		return this.buyResourceCost;
	}

	public int getplayerPoint() {
		return this.playerPoint;
	}

	public void increasePlayerPoint(int point) {
		this.playerPoint += point;
	}

	public void addChainSymbol(String chainSymbol) {
		this.chainSymbols.addChainSymbols(chainSymbol);
	}
	public ChainSymbols getChainSymbols() {
		return chainSymbols;
	}
	public int getSellResourceGain() {
		return sellResourceGain;
	}
	public void setSellResourceGain(int sellResourceGain) {
		this.sellResourceGain = sellResourceGain;
	}
}