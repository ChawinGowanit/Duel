package Card;


import Card.base.Attackable;
import Card.base.Cost;
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
	private Cost cost;
	private Cost resource;

	public PlaceCard(String name, String image, int attackPoint, int playerPoint, boolean repeatTurn,
			Cost cost, Cost resource) {
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
		AttackBoard.attackTime(ATKplayer,this);
	}

	@Override
	public void addPlayerPoint(Player player) {
		// TODO Auto-generated method stub
		player.increasePlayerPoint(this.playerPoint);
	}

	@Override
	public void addPlayerCounter(Player player) {
		// TODO Auto-generated method stub
		player.setResourceCounter(Cost.addCost(this.resource,player.getResourceCounter()));
	}
	public int getAttackPoint() {
		return attackPoint;
	}

}
