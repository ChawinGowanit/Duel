package Card;

import java.util.HashMap;

import Card.base.Card;
import Card.base.haveResource;

public class ResourceCard extends Card implements haveResource{
	private HashMap<String, Integer> resource;

	public ResourceCard(String name, String image, String type, int age, int[] position, boolean pickAble,
			boolean flipAble, boolean isFlip,HashMap<String, Integer> cost,HashMap<String,Integer> resource) {
		super(name,image,"resourceCard",age,position,pickAble,flipAble,isFlip,cost);
		this.resource = resource ;
	}

/*
 * public void addPlayerCounter(Player player) {
 * 
 * }
 */
}