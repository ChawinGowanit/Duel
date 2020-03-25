package Card;

import java.util.HashMap;

import Card.base.Attackable;
import Card.base.HavePoint;
import Card.base.HaveResource;
import logic.Player;
import logic.AttackBoard;


public class PlaceCard implements HavePoint, HaveResource, Attackable {
	private String name;
	private String image;
	private int attackPoint;
	private int playerPoint;
	private boolean repeatTurn;
	private HashMap<String, Integer> cost;
	private HashMap<String, Integer> resource;

	public PlaceCard(String name, String image, int attackPoint, int playerPoint, boolean repeatTurn,
			HashMap<String, Integer> cost, HashMap<String, Integer> resource) {
		this.name = name;
		this.image = image;

		this.attackPoint = attackPoint;
		this.playerPoint = playerPoint;
		this.repeatTurn = repeatTurn;
		this.cost = cost;
		this.resource = resource;
	}

	@Override
	public void attackPlayer(Player ATKplayer) {
		// TODO Auto-generated method stub
		
		AttackBoard.attackTime(ATKplayer);
	}

	@Override
	public void addPlayerPoint(Player player) {
		// TODO Auto-generated method stub
		player.increasePlayerPoint(this.playerPoint);
	}

	@Override
	public void addPlayerCounter(Player player) {
		// TODO Auto-generated method stub
		for (String resource : resource.keySet()) {
			for (String playerResource : player.getResourceCounter().keySet()) {
				if (resource.equals(playerResource)) {
					player.increaseResourceCounter(resource, this.resource.get(resource));
				}
			}

		}
	}

}
