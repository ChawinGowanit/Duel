package Card;

import java.util.HashMap;

import Card.base.Attackable;
import Card.base.HaveMoney;
import Card.base.HavePoint;
import Card.base.HaveResource;
import logic.Player;

public class WonderCard implements HavePoint,HaveMoney,HaveResource,Attackable{
	private String name;
	
	private String image;
	private int attackPoint;
	private int playerPoint;
	private boolean repeatTurn;
	private HashMap<String, Integer> cost;
	private HashMap<String, Integer> resource;
	private int playerMoney;
	
	public WonderCard(String name, String image,  int attackPoint, int playerPoint, boolean repeatTurn,
			HashMap<String, Integer> cost, HashMap<String, Integer> resource,int playerMoney) {
		this.name = name;
		this.image = image;
		
		this.attackPoint = attackPoint;
		this.playerPoint = playerPoint;
		this.repeatTurn = repeatTurn;
		this.cost = cost;
		this.resource = resource;
		this.playerMoney = playerMoney;
	}
	
	@Override
	public void attackPlayer(Player ATKplayer, Player player) {
		// TODO Auto-generated method stub
		player.getPlayer(ATKplayer,player).setAttackPoint(player.getAttackpoint() - this.attackPoint);
	}

	@Override
	public void addMoney(Player player) {
		// TODO Auto-generated method stub
		player.increasePlayerMoney(this.playerMoney);
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
