package Card;

import java.util.HashMap;

import Card.base.Card;
import Card.base.attackAble;
import Card.base.haveChainSymbol;
import logic.Player;

public class AttackCard extends Card implements haveChainSymbol, attackAble {
	private int attackPoint;
	private String chainSymbol;

	public AttackCard(String name, String image, String type, int age, int[] position, boolean pickAble,
			boolean flipAble, boolean isFlip, HashMap<String, Integer> cost, int attackPoint, String chainSymbol) {
		super(name, image, "resourceCard", age, position, pickAble, flipAble, isFlip, cost);
		this.attackPoint = attackPoint;
		this.chainSymbol = chainSymbol;
	}

	public void addChainSymbol(Player player) {
		player.addChainSymbol(this.chainSymbol);
	}

	public void attackPlayer(Player player) {
		if (player.geNum() == 1) {
			player.getPlayer(2).setAttackPoint(player.getAttackpoint() - this.attackPoint);
		} else {
			player.getPlayer(1).setAttackPoint(player.getAttackpoint() - this.attackPoint);
		}
	}

}
