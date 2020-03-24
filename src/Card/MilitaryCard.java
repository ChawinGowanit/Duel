package Card;

import java.util.HashMap;

import Card.base.Attackable;
import Card.base.Card;
import Card.base.HaveChainSymbol;
import logic.Player;

public class MilitaryCard extends Card implements HaveChainSymbol,Attackable{
	
	private String chainSymbol;
	private int attackPoint;
	
	
	public MilitaryCard(String name,  String type, int age, 
			HashMap<String, Integer> cost, int attackPoint, String chainSymbol) {
		super(name, "resourceCard", age,  cost);
		this.attackPoint = attackPoint;
		this.chainSymbol = chainSymbol;
	}
	public void attackPlayer(Player ATKplayer, Player player) {
		
		
	}

	
	public void addChainSymbol(Player player) {
		player.addChainSymbol(this.chainSymbol);
		
	}
	
	
	public int getAttackPoint() {
		return attackPoint;
	}
}
