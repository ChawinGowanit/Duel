package application;

import java.util.ArrayList;

import Card.PlaceCard;
import Card.base.Cost;

public class InitialPlaceCard {
	public ArrayList<PlaceCard> placeCardDeck ;
	
	public InitialPlaceCard() {
		placeCardDeck = new ArrayList<PlaceCard>() ;
		this.placeCardDeck.add(new PlaceCard("Bar",0,6,new Cost(1,1,0,0,2,0),new Cost())) ;
		this.placeCardDeck.add(new PlaceCard("Hotel",0,3,new Cost(0,0,2,1,1,0),new Cost(0,0,0,0,0,3))) ;
		this.placeCardDeck.add(new PlaceCard("Lungman's Command Center",1,3,new Cost(1,1,0,2,0,0),new Cost())) ;
		this.placeCardDeck.add(new PlaceCard("Lungman's Uptown",2,3,new Cost(3,0,0,0,1,0),new Cost())) ;
		this.placeCardDeck.add(new PlaceCard("Rhodes Island",1,3,new Cost(0,2,1,0,1,0),new Cost())) ;
		this.placeCardDeck.add(new PlaceCard("Rhodes Island's server room",0,0,new Cost(0,1,1,1,1,0),new Cost(0,0,0,0,0,12))) ;
		this.placeCardDeck.add(new PlaceCard("Rhodes Island's infirmary",0,9,new Cost(0,3,0,1,0,0),new Cost())) ;
		this.placeCardDeck.add(new PlaceCard("Victirian Mounted Cave",0,3,new Cost(2,2,0,1,0,0),new Cost(0,0,0,0,0,3))) ;	
	}
	public ArrayList<PlaceCard> getPlaceCardDeck() {
		return placeCardDeck;
	}
}
