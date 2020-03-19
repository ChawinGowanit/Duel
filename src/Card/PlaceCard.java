package Card;

import java.util.HashMap;

import Card.base.Card;
import Card.base.attackAble;
import Card.base.havePoint;
import Card.base.haveResource;

public class PlaceCard implements haveResource,havePoint,attackAble{
	private String name ;
	private String image ;
	private int position;
	private int attackPoint ;
	private int playerPoint ;
	private boolean repeatTurn ;
	private HashMap<String, Integer> cost ;
	private HashMap<String, Integer> resource ;
	
	public PlaceCard(String name,String image,int position,int attackPoint,int playerPoint,boolean repeatTurn,HashMap<String, Integer> cost,HashMap<String, Integer> resource) {
		this.name = name ;
		this.image = image ;
		this.position = position ;
		this.attackPoint = attackPoint;
		this.playerPoint = playerPoint ;
		this.repeatTurn = repeatTurn ;
		this.cost = cost ;
		this.resource = resource;
	}
	/*
	 * public void addPlayerCounter(Player player){
	 * 
	 * }
	 *
	 * public void attackPlayer(Player player){
	 * 
	 * }
	 * 
	 * public void addPlayerPoint(Player player){
	 * 
	 * }
	 */
	
	
}
