package logic;

import java.util.ArrayList;

import Card.PlaceCard;

public class PlaceBoard {
	private ArrayList<PlaceCard> placeListPlayer1 ;
	private ArrayList<PlaceCard> placeListPlayer2 ;
	public PlaceBoard() {
		placeListPlayer1 = new ArrayList<PlaceCard>();
		placeListPlayer2 = new ArrayList<PlaceCard>();
	}
	
	
	public void construction(Player player,PlaceCard card) {
		if (player.getNum()==1){
			placeListPlayer1.add(card);
		}else {
			placeListPlayer2.add(card);
		}
		
	}
	
	public void specialEffect(PlaceCard card) {
		String j = card.getName();
		switch (j){
			case "bar":
				/////////////////////////////
				break;
			
			case "Hotel":
				////////////////////////////
				break;
			case "Lungman's Command Center":
				///////////////////////////
				break;
			case "Lungman's Uptown":
				////////////////////
				break;
			case "Rhodes Island":
				///////////////////////////
				break;
			case "Rhodes Island's server room":
				////////////////////////////
				break;
			case "Rhodes Island's infirmary":
				/////////////////////////
				break;
			default:
				///////////////////////
		}
				
	}
	
}
