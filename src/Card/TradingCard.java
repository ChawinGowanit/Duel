package Card;

import java.util.HashMap;

import Card.base.Card;
import Card.base.haveChainSymbol;
import Card.base.haveResource;
import logic.Player;

public class TradingCard extends Card implements haveResource, haveChainSymbol {
	private String chainSymbol;
	private HashMap<String, Integer> resource;

	public TradingCard(String name, String image, String type, int age, int[] position, boolean pickAble,
			boolean flipAble, boolean isFlip, HashMap<String, Integer> cost, String chainSymbol,
			HashMap<String, Integer> resource) {
		super(name, image, "resourceCard", age, position, pickAble, flipAble, isFlip, cost);
		this.chainSymbol = chainSymbol;
		this.resource = resource;
	}

	public void addChainSymbol(Player player) {
		player.addChainSymbol(this.chainSymbol);
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