package Card;

import Card.base.Card;
import Card.base.Cost;
import Card.base.HaveResource;
import logic.Player;

public class RawMaterialCard extends Card implements HaveResource{
	private Cost resource;
	
	public RawMaterialCard(String name,Cost cost,Cost resource) {
		super(name,cost);
		this.resource = resource;
	}
	
	public void addPlayerCounter(Player player) {
		player.setResourceCounter(Cost.addCost(this.resource,player.getResourceCounter()));
	}
	public Cost getResource() {
		return resource;
	}
}
