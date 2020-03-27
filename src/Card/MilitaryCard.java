package Card;



import Card.base.Attackable;
import Card.base.Card;
import Card.base.ChainSymbols;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import application.GameController;
import logic.Player;
import logic.AttackBoard;;
public class MilitaryCard extends Card implements HaveChainSymbol,Attackable{
	
	private ChainSymbols chainSymbol;
	private int attackPoint;
	
	
	public MilitaryCard(String name, Cost cost, int attackPoint, ChainSymbols chainsymbol) {
		super(name, cost);
		this.attackPoint = attackPoint;
		this.chainSymbol = chainsymbol;
	}	
	public void attackPlayer(Player ATKplayer) {

		GameController.ATKboard.attackTime(ATKplayer,this);
		
	}
	public void addChainSymbol(Player player) {
		for (String chainSymbol:this.chainSymbol.getChainSymbol()) {
		player.addChainSymbol(chainSymbol);
		}
	}	
	public int getAttackPoint() {
		return attackPoint;
	}
}
