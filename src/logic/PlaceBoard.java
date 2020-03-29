package logic;

import java.util.ArrayList;

import Card.PlaceCard;
import Card.base.Cost;

public class PlaceBoard {
	//rename
	private static ArrayList<PlaceCard> cardOnBoard ;
	private ArrayList<PlaceCard> placeListPlayer1 ;
	private ArrayList<PlaceCard> placeListPlayer2 ;
	private PlaceCard blankPlace ;
	public PlaceBoard() {
		cardOnBoard = new ArrayList<PlaceCard>() ;
		placeListPlayer1 = new ArrayList<PlaceCard>();
		placeListPlayer2 = new ArrayList<PlaceCard>();
		blankPlace = new PlaceCard("", 0, 0, new Cost(), new Cost()) ;		
	}
	
	public void addCardOnBoard(ArrayList<PlaceCard> placeCardDeck) {
		int i = 0 ;
		for (PlaceCard card : placeCardDeck ) {
			card.setPosition(i);
			cardOnBoard.add(card) ;
			i++;
		}
	}
	
	public void construction(Player player,PlaceCard card) {
		if (player.getNum()==1){
			placeListPlayer1.add(card);
		}else {
			placeListPlayer2.add(card);
		}
		
	}
	
	public PlaceCard getPlaceCardFromName(String name) {
		PlaceCard outputCard = null ;
		for (PlaceCard placeCard : cardOnBoard) {
			if (placeCard.getName().equals(name)) {
				outputCard =  placeCard ;
			}
		}
		return outputCard ;
	}

	public ArrayList<PlaceCard> getPlaceCardOnBoard() {
		// TODO Auto-generated method stub
		return cardOnBoard;
	}

	public void removeCardFromBoard(PlaceCard card, int phase) {
		// TODO Auto-generated method stub
		cardOnBoard.set(card.getPosition(), blankPlace) ;
	}
	
}
