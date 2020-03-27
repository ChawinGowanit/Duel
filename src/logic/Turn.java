package logic;

import Card.PlaceCard;
import Card.base.Card;
import Card.base.Cost;

public class Turn {
	private int playerTurn;
	private boolean repeatTurn;

	public Turn() {
		this.playerTurn = 1;
		this.repeatTurn = false;
	}

	public boolean pickCard(Card card) {

		if (card.getPickAble()) {
			Mainboard.removeCard(card);
			return true ;
		} else {
			
		}
	}

	public boolean build(Card card, Player player) {
		place.create(Player, card);
	}

	public void sell(Card card, Player player) {
		player.setResourceCounter(Cost.addCost(player.getResourceCounter(),new Cost(0,0,0,0,0,2)));
	}

	public boolean buildPlace(PlaceCard card) {
		
	}

	public void switchPlayerTurn() {
		if (this.playerTurn == 1) {
			this.playerTurn = 2;
		} else {
			this.playerTurn = 1;
		}
	}
	public void updateCardOnBoard() {
		
	}
}
