package logic;

import Card.PlaceCard;
import Card.base.Card;

public class Turn {
	private int playerTurn ;
	private boolean repeatTurn ;
	
	public Turn() {
		this.playerturn = 1 ;
		this.repeatTurn = false ;
	}
	public boolean pickCard(Card card) {
		
	}
	public boolean build(Card card) {
		
	}
	public void sell(Card card) {
		
	}
	public boolean buildPlace(PlaceCard card) {
		
	}
	public void setRepeatTurn(boolean repeat) {
		this.repeatTurn = repeat ;
	}
	public void switchPlayerTurn() {
		if (this.repeatTurn ) {
			this.playerTurn = this.playerTurn ;
			this.repeatTurn = false ;
		} else {
			if (this.playerTurn == 1) {
				this.playerTurn = 2 ;
			} else {
				this.playerTurn = 1 ;
			}
		}
	}
}
