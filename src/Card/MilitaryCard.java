package Card;

import Card.base.Attackable;
import Card.base.Card;
import Card.base.ChainSymbols;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import application.GameController;
import logic.Player;

public class MilitaryCard extends Card implements HaveChainSymbol, Attackable {

	private ChainSymbols chainSymbol;
	private int attackPoint;

	public MilitaryCard(String name, Cost cost, int attackPoint, ChainSymbols chainsymbol) {
		super(name, cost);
		if (attackPoint < 0) {
			this.attackPoint = 0;
		} else {
			this.attackPoint = attackPoint;
		}
		this.chainSymbol = chainsymbol;
	}

	public void attackPlayer(Player ATKplayer) {

		GameController.ATKboard.attackTime(ATKplayer, this);

	}

	public boolean addChainSymbol(Player player) {
		boolean result = false;
		for (String chainSymbol:this.chainSymbol.getChainSymbol()) {
			player.addChainSymbol(chainSymbol);
		}
		return result;
	}

	public int getAttackPoint() {
		return attackPoint;
	}

	@Override
	public ChainSymbols getChainSymbols() {
		// TODO Auto-generated method stub
		return this.chainSymbol;
	}
}
