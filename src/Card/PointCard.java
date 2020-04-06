package Card;


import Card.base.Card;
import Card.base.ChainSymbols;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import Card.base.HavePoint;
import logic.Player;

public class PointCard extends Card implements HaveChainSymbol, HavePoint {
	private int point;
	private ChainSymbols chainSymbol;

	public PointCard(String name, Cost cost, int point,  ChainSymbols chainsymbol) {
		super(name, cost);
		if (point < 0) {
			this.point = 0 ;
		} else {
			this.point = point;
		}
		this.chainSymbol = chainsymbol;
	}

	public void addChainSymbol(Player player) {
		for (String chainSymbol:this.chainSymbol.getChainSymbol()) {
		player.addChainSymbol(chainSymbol);
		}
	}

	public void addPlayerPoint(Player player) {
		player.increasePlayerPoint(this.point);
	}
	public ChainSymbols getChainSymbols() {
		// TODO Auto-generated method stub
		return this.chainSymbol;
	}
	public int getPlayerPoint() {
		return point;
	}
}
