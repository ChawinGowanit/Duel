 package Card;


import Card.base.Card;
import Card.base.ChainSymbols;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import Card.base.HavePoint;
import Card.base.HaveResource;
import logic.Player;

public class TradingCard extends Card implements HaveResource, HaveChainSymbol,HavePoint {
	private ChainSymbols chainSymbol;
	private Cost resource;
	private Cost reduceCost;
	private int point;

	public TradingCard(String name, Cost cost, ChainSymbols chainsymbol, Cost resource, Cost reduceCost, int point) {
		super(name, cost);
		this.chainSymbol = chainsymbol;
		this.resource = resource;
		this.reduceCost = reduceCost;
		if (point<0) {
			this.point = 0 ;
		} else {
			this.point = point ;
		}
	}

	public void addChainSymbol(Player player) {
		for (String chainSymbol:this.chainSymbol.getChainSymbol()) {
		player.addChainSymbol(chainSymbol);
		}
	}
	public void addPlayerCounter(Player player) {
		player.setResourceCounter(Cost.addCost(this.resource,player.getResourceCounter()));
	}
	
	public void reducePlayerBuyResourceCost(Player player) {
		player.setBuyResourceCost(Cost.reduceCost(player.getbuyResourceCost(), this.reduceCost));
	}
	public void addPlayerPoint(Player player) {
		player.increasePlayerPoint(this.point);
	}
	public ChainSymbols getChainSymbols() {
		// TODO Auto-generated method stub
		return this.chainSymbol;
	}
	public Cost getReduceCost() {
		return reduceCost;
	}
	public int getPoint() {
		return point;
	}
}