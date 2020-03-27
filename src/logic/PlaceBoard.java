package logic;

import java.util.ArrayList;

import Card.PlaceCard;

public class PlaceBoard {
	private ArrayList<PlaceCard> cardOnBoard ;
	private ArrayList<PlaceCard> placeListPlayer1 ;
	private ArrayList<PlaceCard> placeListPlayer2 ;
	public PlaceBoard() {
		cardOnBoard = new ArrayList<PlaceCard>() ;
		placeListPlayer1 = new ArrayList<PlaceCard>();
		placeListPlayer2 = new ArrayList<PlaceCard>();
	}
	
	public void addCardOnBoard(ArrayList<PlaceCard> placeCardDeck) {
		cardOnBoard.addAll(placeCardDeck) ;
	}
	
	public void construction(Player player,PlaceCard card) {
		if (player.getNum()==1){
			placeListPlayer1.add(card);
		}else {
			placeListPlayer2.add(card);
		}
		
	}
	//เดี๋ยวค่อยมาทำ
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
