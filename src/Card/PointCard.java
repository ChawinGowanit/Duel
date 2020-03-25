package Card;

import Card.base.Card;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import Card.base.HavePoint;
import logic.Player;

public class PointCard extends Card implements HaveChainSymbol, HavePoint {
	private int point;
	private String chainSymbol;

	public PointCard(String name, Cost cost, int point, String chainSymbol) {
		super(name, cost);
		this.point = point;
		this.chainSymbol = chainSymbol;
	}

	public void addChainSymbol(Player player) {
		player.addChainSymbol(this.chainSymbol);
	}

	public void addPlayerPoint(Player player) {
		player.increasePlayerPoint(this.point);
	}

}
