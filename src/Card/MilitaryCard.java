package Card;


import Card.base.Attackable;
import Card.base.Card;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import logic.Player;
import logic.AttackBoard;;
public class MilitaryCard extends Card implements HaveChainSymbol,Attackable{
	
	private String chainSymbol;
	private int attackPoint;
	
	
	public MilitaryCard(String name, Cost cost, int attackPoint, String chainSymbol) {
		super(name, cost);
		this.attackPoint = attackPoint;
		this.chainSymbol = chainSymbol;
	}	
	public void attackPlayer(Player ATKplayer) {

		AttackBoard.attackTime(ATKplayer,this);
		
	}
	public void addChainSymbol(Player player) {
		player.addChainSymbol(this.chainSymbol);
		
	}	
	public int getAttackPoint() {
		return attackPoint;
	}
}
