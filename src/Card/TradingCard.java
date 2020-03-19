package Card;

import java.util.HashMap;

import Card.base.Card;
import Card.base.haveChainSymbol;
import Card.base.haveResource;

public class TradingCard extends Card implements haveResource,haveChainSymbol{
	private String chainSymbol;
	private String changePlayerRule;
	private HashMap<String, Integer> resource;

	public TradingCard(String name, String image, String type, int age, int[] position, boolean pickAble,
			boolean flipAble, boolean isFlip, HashMap<String, Integer> cost,String chainSymbol,String changePlayerRule,HashMap<String,Integer> resource) {
		super(name, image, "resourceCard", age, position, pickAble, flipAble, isFlip, cost);
		this.chainSymbol = chainSymbol ;
		this.changePlayerRule = changePlayerRule ;
		this.resource = resource ;
	}
	/*
	 * public void addChainSymbol(Player player){
	 * 
	 * }
	 * 
	 * public void addPlayerCounter(Player player){
	 * 
	 * }
	 */
}