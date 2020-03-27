package logic;

import java.util.Scanner;

import Card.PlaceCard;
import Card.base.Attackable;
import Card.base.Card;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import Card.base.HavePoint;
import Card.base.HaveResource;
import application.GameController;

public class Turn {
	private static Scanner keyboard = new Scanner(System.in);
	private int playerTurn;
	private boolean repeatTurn;
	private int phase = GameController.getPhase() ;

	public Turn() {
		this.playerTurn = 1;
		this.repeatTurn = false;
	}

	public void turnConTroller(Card card,int phase) {
		if (card.getPickAble()) {
			System.out.println("what do you want do to ? [build,sell,buildPlace]");
			switch (keyboard.nextLine()) {
			case "build":
				if (playerTurn == 1) {
					if(build(card, GameController.player1)) {
						build(card, GameController.player1);
						GameController.mainBoard.removeCardFromBoard(card,phase);
					} else {
						turnConTroller(card,phase) ;
					}
				} else {
					if (build(card, GameController.player2)) {
						build(card, GameController.player2);
						GameController.mainBoard.removeCardFromBoard(card,phase);
					} else {
						turnConTroller(card,phase) ;
					}
				}
			case "sell" :
				if (playerTurn == 1) {
					sell(card, GameController.player1);
				} else {
					sell(card, GameController.player2);
				}
			case "buildPlace" :
				/**/
	}

	public boolean build(Card card, Player player) {
		if (Cost.checkCost(player.getResourceCounter(), card.getCost())) {
			if (card instanceof HaveResource) {
				((HaveResource) card).addPlayerCounter(player);
			}
			if (card instanceof HavePoint) {
				((HavePoint) card).addPlayerPoint(player);
			}
			if (card instanceof HaveChainSymbol) {
				((HaveChainSymbol) card).addChainSymbol(player);
			}
			if (card instanceof Attackable) {
				((Attackable) card).attackPlayer(player);
			}
			return true;
		} else if (Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost()) <= player
				.getResourceCounter().getLMD()) {
			System.out.println("Build? [y/n]");
			switch (keyboard.nextLine()) {
			case "y":
				player.setResourceCounter(Cost.reduceCost(player.getResourceCounter(), new Cost(0, 0, 0, 0, 0,
						Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost()))));
				if (card instanceof HaveResource) {
					((HaveResource) card).addPlayerCounter(player);
				}
				if (card instanceof HavePoint) {
					((HavePoint) card).addPlayerPoint(player);
				}
				if (card instanceof HaveChainSymbol) {
					((HaveChainSymbol) card).addChainSymbol(player);
				}
				if (card instanceof Attackable) {
					((Attackable) card).attackPlayer(player);
				}
				return true;
			case "n":
				return false;
			default:
				return false;
			}

		} else {
			return false;
		}

	}

	public void sell(Card card, Player player) {
		player.setResourceCounter(Cost.addCost(player.getResourceCounter(), new Cost(0, 0, 0, 0, 0, 2)));
	}

	public boolean buildPlace(PlaceCard card, Player player) {
		if (Cost.checkCost(player.getResourceCounter(), card.getCost())) {
			if (card instanceof HaveResource) {
				((HaveResource) card).addPlayerCounter(player);
			}
			if (card instanceof HavePoint) {
				((HavePoint) card).addPlayerPoint(player);
			}
			if (card instanceof HaveChainSymbol) {
				((HaveChainSymbol) card).addChainSymbol(player);
			}
			if (card instanceof Attackable) {
				((Attackable) card).attackPlayer(player);
			}
			return true;
		} else if (Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost()) <= player
				.getResourceCounter().getLMD()) {
			System.out.println("Build? [y/n]");
			String respond = keyboard.nextLine();
			switch (respond) {
			case "y":
				player.setResourceCounter(Cost.reduceCost(player.getResourceCounter(), new Cost(0, 0, 0, 0, 0,
						Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost()))));
				if (card instanceof HaveResource) {
					((HaveResource) card).addPlayerCounter(player);
				}
				if (card instanceof HavePoint) {
					((HavePoint) card).addPlayerPoint(player);
				}
				if (card instanceof HaveChainSymbol) {
					((HaveChainSymbol) card).addChainSymbol(player);
				}
				if (card instanceof Attackable) {
					((Attackable) card).attackPlayer(player);
				}
				return true;
			case "n":
				return false;
			default:
				return false;
			}

		} else {
			return false;
		}
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
