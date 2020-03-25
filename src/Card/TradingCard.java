package Card;

import Card.base.Card;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import Card.base.HaveResource;
import logic.Player;

public class TradingCard extends Card implements HaveResource, HaveChainSymbol {
	private String chainSymbol;
	private Cost resource;
	private String changeRule;
	private int point;

	public TradingCard(String name, Cost cost, String chainSymbol, Cost resource, String changeRule, int point) {
		super(name, cost);
		this.chainSymbol = chainSymbol;
		this.resource = resource;
		this.changeRule = changeRule;
		this.point = point;
	}

	public void addChainSymbol(Player player) {
		player.addChainSymbol(this.chainSymbol);
	}

	public void addPlayerCounter(Player player) {

	}

}