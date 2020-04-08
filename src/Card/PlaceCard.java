package Card;

import Card.base.Attackable;
import Card.base.Cost;
import Card.base.HavePoint;
import Card.base.HaveResource;
import application.GameController;
import logic.Player;

public class PlaceCard implements HavePoint, HaveResource, Attackable {
	private String name;
	private int attackPoint;
	private int playerPoint;
	private int position;
	private Cost cost;
	private Cost resource;

	public PlaceCard(String name, int attackPoint, int playerPoint, Cost cost, Cost resource) {
		this.name = name;
		if (attackPoint < 0) {
			this.attackPoint = 0;
		} else {
			this.attackPoint = attackPoint;
		}
		if (playerPoint < 0) {
			this.playerPoint = 0;
		} else {
			this.playerPoint = playerPoint;
		}
		this.cost = cost;
		this.resource = resource;
		this.position = 0;
	}

	@Override
	public void attackPlayer(Player ATKplayer) {
		// TODO Auto-generated method stub
		GameController.ATKboard.attackTime(ATKplayer, this);
	}

	@Override
	public void addPlayerPoint(Player player) {
		// TODO Auto-generated method stub
		player.increasePlayerPoint(this.playerPoint);
	}

	@Override
	public void addPlayerCounter(Player player) {
		// TODO Auto-generated method stub
		player.setResourceCounter(Cost.addCost(this.resource, player.getResourceCounter()));
	}

	public int getAttackPoint() {
		return attackPoint;
	}

	public String getName() {
		return name;
	}

	public void constructPlace(Player player) {
		GameController.placeBoard.construction(player, this);
	}

	public Cost getCost() {
		return this.cost;
	}

	public String toString() {
		return this.name;
	}

	public void setPosition(int i) {
		// TODO Auto-generated method stub
		this.position = i;
	}

	public int getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	public int getPlayerPoint() {
		return playerPoint;
	}

	public Cost getResource() {
		return resource;
	}

	public String getImgURL() {
		return "/" + this.name + ".png";
	}
}
