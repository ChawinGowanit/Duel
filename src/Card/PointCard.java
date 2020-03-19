package Card;

import java.util.HashMap;

import Card.base.Card;
import Card.base.haveChainSymbol;
import Card.base.havePoint;

public class PointCard extends Card implements haveChainSymbol,havePoint{
	private int point ;
	private String chainSymbol ;
	public PointCard(String name, String image, String type, int age, int[] position, boolean pickAble,
			boolean flipAble, boolean isFlip, HashMap<String, Integer> cost,int point,String chainSymbol) {
		super(name, image, "resourceCard", age, position, pickAble, flipAble, isFlip, cost);
		this.point = point ;
		this.chainSymbol = chainSymbol ;
	}
	/*
	 * public void addChainSymbol(Player player){
	 * 
	 * }
	 * public void addPlayerPoint(Player player){
	 * 
	 * }
	 */
}
