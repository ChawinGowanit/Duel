package logic;

import java.util.ArrayList;
import java.util.Collections;

import Card.TradingCard;
import Card.base.Card;
import Card.base.ChainSymbols;
import Card.base.Cost;
import application.InitialCardDeck;

public class MainBoard {
	private ArrayList<Card> startingCardOnBoard;
	private ArrayList<Card> midGameCardOnBoard;
	private ArrayList<Card> lateGameCardOnBoard;
	private Card blankCard;

	public MainBoard() {
		this.startingCardOnBoard = new ArrayList<Card>();
		this.midGameCardOnBoard = new ArrayList<Card>();
		this.lateGameCardOnBoard = new ArrayList<Card>();
		this.blankCard = new TradingCard("", new Cost(), new ChainSymbols(), new Cost(), new Cost(), 0);
		this.blankCard.setFlipAble(true);
		this.blankCard.setPickAble(true);
	}

	public void addCardOnBoard(InitialCardDeck initialCardDeck, int phase) {
		switch (phase) {
		case 1:
			this.shuffleCeck(initialCardDeck, phase);
			int i = 1;
			for (Card card : initialCardDeck.startingCard) {
				card.setPosition(i);
				i++;
				this.startingCardOnBoard.add(card);
			}
			break;
		case 2:
			this.shuffleCeck(initialCardDeck, phase);
			int i1 = 1;
			for (Card card : initialCardDeck.midGameCard) {
				card.setPosition(i1);
				i1++;
				this.midGameCardOnBoard.add(card);
			}
			break;
		case 3:
			this.shuffleCeck(initialCardDeck, phase);
			int i2 = 1;
			for (Card card : initialCardDeck.lateGameCard) {
				card.setPosition(i2);
				i2++;
				this.lateGameCardOnBoard.add(card);
			}
			break;
		}
	}

	public void removeCardFromBoard(Card card, int phase) {
		switch (phase) {
		case 1:
			this.startingCardOnBoard.set(this.startingCardOnBoard.indexOf(card), blankCard);
			break;
		case 2:
			this.midGameCardOnBoard.set(this.midGameCardOnBoard.indexOf(card), blankCard);
			break;
		case 3:
			this.lateGameCardOnBoard.set(this.lateGameCardOnBoard.indexOf(card), blankCard);
			break;
		}
	}

	public void firstUpdateCardOnBoard(int phase) {
		switch (phase) {
		case 1:
			for (Card card : this.startingCardOnBoard) {
				if (card.getPosition() == 1 || card.getPosition() == 2 || card.getPosition() == 6
						|| card.getPosition() == 7 || card.getPosition() == 8 || card.getPosition() == 9
						|| card.getPosition() == 15 || card.getPosition() == 16 || card.getPosition() == 17
						|| card.getPosition() == 18 || card.getPosition() == 19 || card.getPosition() == 20) {
					card.setFlipAble(true);
				}
			}
			break;
		case 2:
			for (Card card : this.midGameCardOnBoard) {
				if (card.getPosition() == 1 || card.getPosition() == 2 || card.getPosition() == 6
						|| card.getPosition() == 7 || card.getPosition() == 8 || card.getPosition() == 9
						|| card.getPosition() == 15 || card.getPosition() == 16 || card.getPosition() == 17
						|| card.getPosition() == 18 || card.getPosition() == 19 || card.getPosition() == 20) {
					card.setFlipAble(true);

				}
			}
			break;
		case 3:
			for (Card card : this.lateGameCardOnBoard) {
				if (card.getPosition() == 3 || card.getPosition() == 4 || card.getPosition() == 5
						|| card.getPosition() == 10 || card.getPosition() == 11 || card.getPosition() == 12
						|| card.getPosition() == 13 || card.getPosition() == 17 || card.getPosition() == 18) {
					card.setFlipAble(true);
				}
			}
			break;
		}
	}

	public void updateCardOnBoard(int phase) {
		// update boolean flipAble isFlip pickAble from each card
		if (phase == 1) {
			for (Card card : this.startingCardOnBoard) {
				if (card.getPosition() == 1 || card.getPosition() == 2) {
					if (this.startingCardOnBoard.get(card.getPosition() + 1).equals(blankCard)
							&& this.startingCardOnBoard.get(card.getPosition() + 2).equals(blankCard)) {
						card.setPickAble(true);
					}
				} else if (card.getPosition() == 3 || card.getPosition() == 4 || card.getPosition() == 5) {
					if (this.startingCardOnBoard.get(card.getPosition() + 2).equals(blankCard)
							&& this.startingCardOnBoard.get(card.getPosition() + 3).equals(blankCard)) {
						card.setFlipAble(true);
						card.setPickAble(true);
					}
				} else if (card.getPosition() == 6 || card.getPosition() == 7 || card.getPosition() == 8
						|| card.getPosition() == 9) {
					if (this.startingCardOnBoard.get(card.getPosition() + 3).equals(blankCard)
							&& this.startingCardOnBoard.get(card.getPosition() + 4).equals(blankCard)) {
						card.setPickAble(true);
					}
				} else if (card.getPosition() == 10 | card.getPosition() == 11 | card.getPosition() == 12
						| card.getPosition() == 13 | card.getPosition() == 14) {
					if (this.startingCardOnBoard.get(card.getPosition() + 4).equals(blankCard)
							&& this.startingCardOnBoard.get(card.getPosition() + 5).equals(blankCard)) {
						card.setFlipAble(true);
						card.setPickAble(true);
					}
				} else {
					card.setFlipAble(true);
					card.setPickAble(true);
				}

			}
		} else if (phase == 2) {
			for (Card card : this.midGameCardOnBoard) {
				if (card.getPosition() == 1 | card.getPosition() == 2) {
					if (this.midGameCardOnBoard.get(card.getPosition() + 1).equals(blankCard)
							&& this.midGameCardOnBoard.get(card.getPosition() + 2).equals(blankCard)) {
						card.setPickAble(true);
					}
				} else if (card.getPosition() == 3 | card.getPosition() == 4 | card.getPosition() == 5) {
					if (this.midGameCardOnBoard.get(card.getPosition() + 2).equals(blankCard)
							&& this.midGameCardOnBoard.get(card.getPosition() + 3).equals(blankCard)) {
						card.setFlipAble(true);
						card.setPickAble(true);
					}
				} else if (card.getPosition() == 6 | card.getPosition() == 7 | card.getPosition() == 8
						| card.getPosition() == 8) {
					if (this.midGameCardOnBoard.get(card.getPosition() + 3).equals(blankCard)
							&& this.midGameCardOnBoard.get(card.getPosition() + 4).equals(blankCard)) {
						card.setPickAble(true);
					}
				} else if (card.getPosition() == 10 | card.getPosition() == 11 | card.getPosition() == 12
						| card.getPosition() == 13 | card.getPosition() == 14) {
					if (this.midGameCardOnBoard.get(card.getPosition() + 4).equals(blankCard)
							&& this.midGameCardOnBoard.get(card.getPosition() + 5).equals(blankCard)) {
						card.setFlipAble(true);
						card.setPickAble(true);
					}
				} else {
					card.setFlipAble(true);
					card.setPickAble(true);
				}
			}
		} else {
			for (int i = 0; i == lateGameCardOnBoard.size(); i++) {
				if (i == 0 || i == 1) {
					if (this.lateGameCardOnBoard.get(i + 2).equals(blankCard)
							&& this.lateGameCardOnBoard.get(i + 3).equals(blankCard)) {
						this.lateGameCardOnBoard.get(i).setFlipAble(true);
						this.lateGameCardOnBoard.get(i).setPickAble(true);
					}
				} else if (i == 2 || i == 3 || i == 4) {
					if (this.lateGameCardOnBoard.get(i + 3).equals(blankCard)
							&& this.lateGameCardOnBoard.get(i + 4).equals(blankCard)) {
						this.lateGameCardOnBoard.get(i).setPickAble(true);
					}
				} else if (i == 5 || i == 6 || i == 7 || i == 8) {
					if (this.lateGameCardOnBoard.get(i + 4).equals(blankCard)) {
						this.lateGameCardOnBoard.get(i).setFlipAble(true);
						this.lateGameCardOnBoard.get(i).setPickAble(true);
					}
				} else if (i == 9 || i == 10 || i == 11 || i == 12) {
					if (i == 9) {
						if (this.lateGameCardOnBoard.get(i + 4).equals(blankCard)) {
							this.lateGameCardOnBoard.get(i).setPickAble(true);
						}
					} else if (i == 10 || i == 11) {
						if (this.lateGameCardOnBoard.get(i + 3).equals(blankCard)
								&& this.lateGameCardOnBoard.get(i + 4).equals(blankCard)) {
							this.lateGameCardOnBoard.get(i).setPickAble(true);
						}
					} else {
						if (this.lateGameCardOnBoard.get(i + 3).equals(blankCard)) {
							this.lateGameCardOnBoard.get(i).setPickAble(true);
						}
					}
				} else if (i == 13 || i == 14 || i == 15) {
					if (i == 13) {
						if (this.lateGameCardOnBoard.get(i + 3).equals(blankCard)) {
							this.lateGameCardOnBoard.get(i).setFlipAble(true);
							this.lateGameCardOnBoard.get(i).setPickAble(true);
						}
					} else if (i == 14) {
						if (this.lateGameCardOnBoard.get(i + 2).equals(blankCard)
								&& this.lateGameCardOnBoard.get(i + 3).equals(blankCard)) {
							this.lateGameCardOnBoard.get(i).setFlipAble(true);
							this.lateGameCardOnBoard.get(i).setPickAble(true);
						}
					} else {
						if (this.lateGameCardOnBoard.get(i + 2).equals(blankCard)) {
							this.lateGameCardOnBoard.get(i).setFlipAble(true);
							this.lateGameCardOnBoard.get(i).setPickAble(true);
						}
					}
				} else {
					this.lateGameCardOnBoard.get(i).setFlipAble(true);
					this.lateGameCardOnBoard.get(i).setPickAble(true);
				}
			}
		}
	}

	public Card getCardFromName(String name, int phase) {
		Card outCard = null;
		for (Card card : getCardOnBoard(phase)) {
			if (card.getName().equals(name)) {
				outCard = card;
				break;
			}
		}
		return outCard;
	}

	public ArrayList<Card> getCardOnBoard(int i) {
		switch (i) {
		case 1:
			return this.startingCardOnBoard;
		case 2:
			return this.midGameCardOnBoard;
		case 3:
			return this.lateGameCardOnBoard;
		default:
			System.out.println("getCardOnBoard phase input Error");
			return null;
		}
		// TODO Auto-generated method stub

	}

	public boolean checkIfAllBlankCard(ArrayList<Card> cardOnBoard) {
		for (Card card : cardOnBoard) {
			if (!card.equals(blankCard)) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Card> shuffleCeck(InitialCardDeck initialCardDeck, int phase) {
		switch (phase) {
		case 1:
			Collections.shuffle(initialCardDeck.startingCard);
			return initialCardDeck.startingCard ;
		case 2:
			Collections.shuffle(initialCardDeck.midGameCard);
			return initialCardDeck.midGameCard ;
		case 3:
			Collections.shuffle(initialCardDeck.lateGameCard);
			return initialCardDeck.lateGameCard ;
		default :
			return null ;
		}

	}
}
