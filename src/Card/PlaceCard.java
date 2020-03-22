package Card;

import java.util.HashMap;

import Card.base.Card;
import Card.base.attackAble;
import Card.base.havePoint;
import Card.base.haveResource;
import logic.Player;

public class PlaceCard implements haveResource, havePoint, attackAble {
	private String name;
	private String image;
	private int position;
	private int attackPoint;
	private int playerPoint;
	private boolean repeatTurn;
	private HashMap<String, Integer> cost;
	private HashMap<String, Integer> resource;

	public PlaceCard(String name, String image, int position, int attackPoint, int playerPoint, boolean repeatTurn,
			HashMap<String, Integer> cost, HashMap<String, Integer> resource) {
		this.name = name;
		this.image = image;
		this.position = position;
		this.attackPoint = attackPoint;
		this.playerPoint = playerPoint;
		this.repeatTurn = repeatTurn;
		this.cost = cost;
		this.resource = resource;
	}

	public void addPlayerCounter(Player player) {
		for (String resource : resource.keySet()) {
			for (String playerResource : player.getResourceCounter().keySet()) {
				if (resource.equals(playerResource)) {
					player.increaseResourceCounter(resource, this.resource.get(resource));
				}
			}

		}
	}

	public void attackPlayer(Player ATKplayer,Player player) {
		player.getPlayer(ATKplayer,player).setAttackPoint(player.getAttackpoint() - this.attackPoint);
}

	public void addPlayerPoint(Player player) {
		player.increasePlayerPoint(this.playerPoint);
	}

}
