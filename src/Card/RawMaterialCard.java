package Card;

import java.util.HashMap;

import Card.base.Card;
import Card.base.HaveResource;
import logic.Player;

public class RawMaterialCard extends Card implements HaveResource{
	private HashMap<String, Integer> resource;
	
	public RawMaterialCard(String name,HashMap<String ,Integer> cost,HashMap<String, Integer> resource) {
		super(name,cost);
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
	
}
