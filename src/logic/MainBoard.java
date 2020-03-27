package logic;

import java.util.ArrayList;
import java.util.Collections;

import Card.base.Card;
import application.InitialCardDeck;

public class MainBoard {
	private ArrayList<Card> startingCardOnBoard ;
	private ArrayList<Card> midGameCardOnBoard ;
	private ArrayList<Card> lateGameCardOnBoard ;
	
	public MainBoard() {
		this.startingCardOnBoard = new ArrayList<Card>() ;
		this.midGameCardOnBoard = new ArrayList<Card>() ;
		this.lateGameCardOnBoard = new ArrayList<Card>() ;
	}

	public void addCardOnBoard(InitialCardDeck initialCardDeck, int phase) {
		switch (phase) {
		case 1:
			Collections.shuffle(initialCardDeck.startingCard);
			int i = 1;
			for (Card card : initialCardDeck.startingCard) {
				card.setPosition(i);
				i++;
				this.startingCardOnBoard.add(card);
			}
		case 2:
			Collections.shuffle(initialCardDeck.midGameCard);
			int i1 = 1 ;
			for (Card card : initialCardDeck.midGameCard) {
				card.setPosition(i1);
				i1++;
				this.midGameCardOnBoard.add(card);
			}
		case 3:
			Collections.shuffle(initialCardDeck.lateGameCard);
			int i2 = 1 ;
			for (Card card : initialCardDeck.lateGameCard) {
				card.setPosition(i2);
				i2++;
				this.lateGameCardOnBoard.add(card);
			}
		}
	}
	public void removeCardFromBoard(Card card,int phase) {
		switch (phase) {
		case 1:
			this.startingCardOnBoard.remove(card) ;
		case 2:
			this.midGameCardOnBoard.remove(card) ;
		case 3:
			this.lateGameCardOnBoard.remove(card) ;
		}
	}
	public void updateCardOnBoard() {
		//update boolean flipAble isFlip piackAble from each card
		
		
		
	}
	public ArrayList<Card> getStartingCardOnBoard(){
		return this.startingCardOnBoard ;
	}
	public ArrayList<Card> getMidGameCardOnBoard(){
		return this.midGameCardOnBoard ;
	}
	public ArrayList<Card> getLateGameCardOnBoard(){
		return this.lateGameCardOnBoard ;
	}
}
