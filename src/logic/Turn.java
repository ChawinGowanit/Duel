package logic;

import Card.PlaceCard;
import Card.TradingCard;
import Card.base.Attackable;
import Card.base.Card;
import Card.base.ChainSymbols;
import Card.base.Cost;
import Card.base.HaveChainSymbol;
import Card.base.HavePoint;
import Card.base.HaveResource;
import application.GameController;
import logic.exception.PickCardFailException;

public class Turn {
	private static int playerTurn = 1;
	private static Card selectedCard;
	private static PlaceCard selectedPlaceCard;

	public static void setSelectedCard(Card card) throws PickCardFailException {
		if (card.isPickAble()) {
			selectedCard = card;
		} else {
<<<<<<< Updated upstream
			throw new PickCardFailException("This card is not pickable");
||||||| constructed merge base
			throw new PickCardFailException("This card is not pickable!");
=======
			String respond = keyboard.nextLine();
			turnConTroller(GameController.mainBoard.getCardFromName(respond,
					GameController.mainBoard.getStartingCardOnBoard()), GameController.getPhase());
			throw new PickCardFailException("This card is not pickable!");
			
>>>>>>> Stashed changes
		}
	}

	public static void setSelectedPlaceCard(PlaceCard placeCard) {
		selectedPlaceCard = placeCard;
	}

	public static boolean buildController() {
		return canBulid(selectedCard, GameController.getCurrentPlayer());
	}

	public static void build() {
		GameController.getCurrentPlayer()
				.setResourceCounter(Cost.reduceCost(GameController.getCurrentPlayer().getResourceCounter(),
						new Cost(0, 0, 0, 0, 0, Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
								selectedCard.getCost(), GameController.getCurrentPlayer().getbuyResourceCost()))));
		if (selectedCard instanceof HaveResource) {
			((HaveResource) selectedCard).addPlayerCounter(GameController.getCurrentPlayer());
		}
		if (selectedCard instanceof HavePoint) {
			((HavePoint) selectedCard).addPlayerPoint(GameController.getCurrentPlayer());
		}
		if (selectedCard instanceof HaveChainSymbol) {
			((HaveChainSymbol) selectedCard).addChainSymbol(GameController.getCurrentPlayer());
			System.out.println(GameController.getCurrentPlayer().getName() + "'s Chain Symbols :"
					+ GameController.getCurrentPlayer().getChainSymbols());
		}
		if (selectedCard instanceof Attackable) {
			((Attackable) selectedCard).attackPlayer(GameController.getCurrentPlayer());
			System.out.println("Attack!!");
			System.out.println("Attacker's position :" + AttackBoard.getPosition());
			if (GameController.getCurrentPlayer().getNum() == 1) {
				System.out.println(GameController.player2.getName() + "'s resources :"
						+ GameController.player2.getResourceCounter());
			} else {
				System.out.println(GameController.player1.getName() + "'s resources :"
						+ GameController.player1.getResourceCounter());
			}
		}
		if (selectedCard instanceof TradingCard) {
			GameController.getCurrentPlayer()
					.setSellResourceGain(GameController.getCurrentPlayer().getSellResourceGain() + 1);
			System.out.println(GameController.getCurrentPlayer().getName() + "'s new sell card gain = "
					+ GameController.getCurrentPlayer().getSellResourceGain());
			GameController.getCurrentPlayer()
					.setBuyResourceCost(Cost.reduceCost(GameController.getCurrentPlayer().getbuyResourceCost(),
							((TradingCard) selectedCard).getReduceCost()));
			System.out.println(GameController.getCurrentPlayer().getName() + "'s new buy resource cost :"
					+ GameController.getCurrentPlayer().getbuyResourceCost());
		}
		System.out.println(GameController.getCurrentPlayer().getName() + "'s new resources :"
				+ GameController.getCurrentPlayer().getResourceCounter());
		System.out.println(GameController.getCurrentPlayer().getName() + "'s point "
				+ GameController.getCurrentPlayer().getplayerPoint());
		switchPlayerTurn();

	}

	public static void sell() {
		GameController.getCurrentPlayer()
				.setResourceCounter(Cost.addCost(GameController.getCurrentPlayer().getResourceCounter(),
						new Cost(0, 0, 0, 0, 0, GameController.getCurrentPlayer().getSellResourceGain())));
		switchPlayerTurn();
	}

	public static boolean buildPlaceController() {
		if (canBuildPlace(selectedPlaceCard, GameController.getCurrentPlayer())) {
			return true;
		} else {
			return false;
		}
	}

	public static void buildPlace() {
		GameController.getCurrentPlayer()
				.setResourceCounter(Cost.reduceCost(GameController.getCurrentPlayer().getResourceCounter(),
						new Cost(0, 0, 0, 0, 0, Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
								selectedPlaceCard.getCost(), GameController.getCurrentPlayer().getbuyResourceCost()))));
		if (selectedPlaceCard instanceof HaveResource) {
			((HaveResource) selectedPlaceCard).addPlayerCounter(GameController.getCurrentPlayer());
		}
		if (selectedPlaceCard instanceof HavePoint) {
			((HavePoint) selectedPlaceCard).addPlayerPoint(GameController.getCurrentPlayer());
		}
		if (selectedPlaceCard instanceof HaveChainSymbol) {
			((HaveChainSymbol) selectedPlaceCard).addChainSymbol(GameController.getCurrentPlayer());
			System.out.println(GameController.getCurrentPlayer().getName() + "'s Chain Symbols :"
					+ GameController.getCurrentPlayer().getChainSymbols());
		}
		if (selectedPlaceCard instanceof Attackable) {
			((Attackable) selectedPlaceCard).attackPlayer(GameController.getCurrentPlayer());
			System.out.println("Attack!!");
			System.out.println("Attacker's position :" + AttackBoard.getPosition());
			if (GameController.getCurrentPlayer().getNum() == 1) {
				System.out.println(GameController.player2.getName() + "'s resources :"
						+ GameController.player2.getResourceCounter());
			} else {
				System.out.println(GameController.player1.getName() + "'s resources :"
						+ GameController.player1.getResourceCounter());
			}
		}
		System.out.println(GameController.getCurrentPlayer().getName() + "'s new resources :"
				+ GameController.getCurrentPlayer().getResourceCounter());
		System.out.println(GameController.getCurrentPlayer().getName() + "'s point "
				+ GameController.getCurrentPlayer().getplayerPoint());
		GameController.placeBoard.removeCardFromBoard(selectedPlaceCard, GameController.getPhase());
		switchPlayerTurn();
	}

	public static void switchPlayerTurn() {
		if (playerTurn == 1) {
			playerTurn = 2;
		} else {
			playerTurn = 1;
		}
	}

	public static int getPlayerTurn() {
		return playerTurn;
	}

	public static boolean canBulid(Card card, Player player) {
		if ((card instanceof HaveChainSymbol && ChainSymbols.isHaveChainSymbol(player, (HaveChainSymbol) card))
				|| (Cost.checkCost(player.getResourceCounter(), card.getCost()))
				|| (Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost()) <= player
						.getResourceCounter().getLMD())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean canBuildPlace(PlaceCard placeCard, Player player) {
		if ((Cost.checkCost(player.getResourceCounter(), placeCard.getCost()))
				|| (Cost.checkLmd(player.getResourceCounter(), placeCard.getCost(),
						player.getbuyResourceCost()) <= player.getResourceCounter().getLMD())) {
			return true;
		} else {
			return false;
		}
	}

	public static Card getSelectedCard() {
		// TODO Auto-generated method stub
		return selectedCard;
	}

	public static PlaceCard getSelectedPlaceCard() {
		// TODO Auto-generated method stub
		return selectedPlaceCard;
	}

}
