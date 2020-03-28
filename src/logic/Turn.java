package logic;

import java.util.Scanner;

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

public class Turn {
	private static Scanner keyboard = new Scanner(System.in);
	private static int playerTurn;

	public Turn() {
		this.playerTurn = 1;
	}

	public static void turnConTroller(Card card, int phase) throws PickCardFailException {
		if (card.getPickAble()) {
			System.out.println("what do you want do to ? [build,sell,buildPlace]");
			switch (keyboard.nextLine()) {
			case "build":
				if (playerTurn == 1) {
					if (canBulid(card, GameController.player1)) {
						if (build(card, GameController.player1)) {
							System.out.println("-----build complete-----");
							GameController.mainBoard.removeCardFromBoard(card, phase);
						} else{
							System.out.println("please pick new card");
							System.out.println(GameController.placeBoard.getPlaceCardOnBoard());
							System.out.println(GameController.mainBoard.getCardOnBoard(GameController.getPhase()));
							System.out.println("Type Card you want to pick");
							String respond = keyboard.nextLine();
							turnConTroller(GameController.mainBoard.getCardFromName(respond,
									GameController.mainBoard.getStartingCardOnBoard()), GameController.getPhase());
						}
					} else {
						System.out.println("Insufficient material");
						System.out.println("please pick new card");
						System.out.println(GameController.placeBoard.getPlaceCardOnBoard());
						System.out.println(GameController.mainBoard.getCardOnBoard(GameController.getPhase()));
						System.out.println("Type Card you want to pick");
						String respond = keyboard.nextLine();
						turnConTroller(GameController.mainBoard.getCardFromName(respond,
								GameController.mainBoard.getStartingCardOnBoard()), GameController.getPhase());
					}
				} else {
					if (canBulid(card, GameController.player2)) {
						if (build(card, GameController.player2)) {
							System.out.println("-----build complete-----");
							GameController.mainBoard.removeCardFromBoard(card, phase);
						} else{
							System.out.println("please pick new card");
							System.out.println(GameController.placeBoard.getPlaceCardOnBoard());
							System.out.println(GameController.mainBoard.getCardOnBoard(GameController.getPhase()));
							System.out.println("Type Card you want to pick");
							String respond = keyboard.nextLine();
							turnConTroller(GameController.mainBoard.getCardFromName(respond,
									GameController.mainBoard.getStartingCardOnBoard()), GameController.getPhase());
						}
					} else {
						System.out.println("Insufficient material");
						System.out.println("please pick new card");
						System.out.println(GameController.placeBoard.getPlaceCardOnBoard());
						System.out.println(GameController.mainBoard.getCardOnBoard(GameController.getPhase()));
						System.out.println("Type Card you want to pick");
						String respond = keyboard.nextLine();
						turnConTroller(GameController.mainBoard.getCardFromName(respond,
								GameController.mainBoard.getStartingCardOnBoard()), GameController.getPhase());
					}
				}
				switchPlayerTurn();
				break;
			case "sell":
				if (playerTurn == 1) {
					System.out.println("sell complete");
					sell(card, GameController.player1);
					System.out.println(GameController.player1.getName() + "'s resources"
							+ GameController.player1.getResourceCounter());
					GameController.mainBoard.removeCardFromBoard(card, GameController.getPhase());
				} else {
					System.out.println("sell complete");
					sell(card, GameController.player2);
					System.out.println(GameController.player2.getName() + "'s resources"
							+ GameController.player2.getResourceCounter());
					GameController.mainBoard.removeCardFromBoard(card, GameController.getPhase());
				}
				switchPlayerTurn();
				break;
			case "buildPlace":
				if (playerTurn == 1) {
					System.out.println("Type place you want to build");
					String placeCardName = keyboard.nextLine();
					if (canBuildPlace(PlaceBoard.getPlaceCardFromName(placeCardName), GameController.player1)) {
						buildPlace(PlaceBoard.getPlaceCardFromName(keyboard.nextLine()), GameController.player1);
					} else {
						System.out.println("insufficient material!");
						System.out.println("please pick new card");
						System.out.println(GameController.placeBoard.getPlaceCardOnBoard());
						System.out.println(GameController.mainBoard.getCardOnBoard(GameController.getPhase())); // แก้ด้วย
						System.out.println("Type Card you want to pick");
						String respond = keyboard.nextLine();
						turnConTroller(GameController.mainBoard.getCardFromName(respond,
								GameController.mainBoard.getStartingCardOnBoard()), GameController.getPhase());
					}
				} else {
					System.out.println("Type place you want to build");
					String placeCardName = keyboard.nextLine();
					if (canBuildPlace(PlaceBoard.getPlaceCardFromName(placeCardName), GameController.player2)) {
						buildPlace(PlaceBoard.getPlaceCardFromName(keyboard.nextLine()), GameController.player2);
					} else {
						System.out.println("insufficient material!");
						System.out.println("please pick new card");
						System.out.println(GameController.placeBoard.getPlaceCardOnBoard());
						System.out.println(GameController.mainBoard.getCardOnBoard(GameController.getPhase())); // แก้ด้วย
						System.out.println("Type Card you want to pick");
						String respond = keyboard.nextLine();
						turnConTroller(GameController.mainBoard.getCardFromName(respond,
								GameController.mainBoard.getStartingCardOnBoard()), GameController.getPhase());
					}
				}
				switchPlayerTurn();
				break;
				default :{
					String message = "Incorrect command" ;
				}
			}
		} else {
			throw new PickCardFailException("This card is not pickable!");
		}
	}

	public static boolean build(Card card, Player player) throws PickCardFailException {
		if (card instanceof HaveChainSymbol && ChainSymbols.isHaveChainSymbol(player, (HaveChainSymbol) card)) {
			if (card instanceof HaveResource) {
				((HaveResource) card).addPlayerCounter(player);
			}
			if (card instanceof HavePoint) {
				((HavePoint) card).addPlayerPoint(player);
				System.out.println(player.getName() + "'s point :" + player.getplayerPoint());
			}
			if (card instanceof HaveChainSymbol) {
				((HaveChainSymbol) card).addChainSymbol(player);
				System.out.println(player.getName() + "'s Chain Symbols :" + player.getChainSymbols());
			}
			if (card instanceof Attackable) {
				((Attackable) card).attackPlayer(player);
				System.out.println("Attack!!");
				System.out.println("Attacker's position :" + AttackBoard.getPosition());
				if (player.getNum() == 1) {
					System.out.println(GameController.player2.getName()+"'s resources :"+GameController.player2.getResourceCounter());
				} else {
					System.out.println(GameController.player1.getName()+"'s resources :"+GameController.player1.getResourceCounter());
				}
			}
			if (card instanceof TradingCard) {
				player.setSellResourceGain(player.getSellResourceGain() + 1);
				System.out.println(player.getName() + "'s new sell card gain = " + player.getSellResourceGain());
				player.setBuyResourceCost(
						Cost.reduceCost(player.getbuyResourceCost(), ((TradingCard) card).getReduceCost()));
				System.out.println(player.getName() + "'s new buy resource cost :" + player.getbuyResourceCost());
			}
			System.out.println(player.getName() + "'s new resources :" + player.getResourceCounter());
			return true;
		}

		else if (Cost.checkCost(player.getResourceCounter(), card.getCost())) {
			if (card instanceof HaveResource) {
				((HaveResource) card).addPlayerCounter(player);
			}
			if (card instanceof HavePoint) {
				((HavePoint) card).addPlayerPoint(player);
				System.out.println(player.getName() + "'s point :" + player.getplayerPoint());
			}
			if (card instanceof HaveChainSymbol) {
				((HaveChainSymbol) card).addChainSymbol(player);
				System.out.println(player.getName() + "'s Chain Symbols :" + player.getChainSymbols());
			}
			if (card instanceof Attackable) {
				((Attackable) card).attackPlayer(player);
				System.out.println("Attack!!");
				System.out.println("Attacker's position :" + AttackBoard.getPosition());
				if (player.getNum() == 1) {
					System.out.println(GameController.player2.getName()+"'s resources :"+GameController.player2.getResourceCounter());
				} else {
					System.out.println(GameController.player1.getName()+"'s resources :"+GameController.player1.getResourceCounter());
				}
			}
			if (card instanceof TradingCard) {
				player.setSellResourceGain(player.getSellResourceGain() + 1);
				System.out.println(player.getName() + "'s new sell card gain = " + player.getSellResourceGain());
				player.setBuyResourceCost(
						Cost.reduceCost(player.getbuyResourceCost(), ((TradingCard) card).getReduceCost()));
				System.out.println(player.getName() + "'s new buy resource cost :" + player.getbuyResourceCost());
			}
			System.out.println(player.getName() + "'s new resources :" + player.getResourceCounter());
			return true;
		} else if (Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost()) <= player
				.getResourceCounter().getLMD()) {
			System.out.println(
					"spend " + Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost())
							+ " LMD to Build? [y/n]");
			switch (keyboard.nextLine()) {
			case "y":
				player.setResourceCounter(Cost.reduceCost(player.getResourceCounter(), new Cost(0, 0, 0, 0, 0,
						Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost()))));
				if (card instanceof HaveResource) {
					((HaveResource) card).addPlayerCounter(player);
				}
				if (card instanceof HavePoint) {
					((HavePoint) card).addPlayerPoint(player);
					System.out.println(player.getName() + "'s point :" + player.getplayerPoint());
				}
				if (card instanceof HaveChainSymbol) {
					((HaveChainSymbol) card).addChainSymbol(player);
					System.out.println(player.getName() + "'s Chain Symbols :" + player.getChainSymbols());
				}
				if (card instanceof Attackable) {
					((Attackable) card).attackPlayer(player);
					System.out.println("Attack!!");
					System.out.println("Attacker's position :" + AttackBoard.getPosition());
					if (player.getNum() == 1) {
						System.out.println(GameController.player2.getName()+"'s resources :"+GameController.player2.getResourceCounter());
					} else {
						System.out.println(GameController.player1.getName()+"'s resources :"+GameController.player1.getResourceCounter());
					}
				}
				if (card instanceof TradingCard) {
					player.setSellResourceGain(player.getSellResourceGain() + 1);
					System.out.println(player.getName() + "'s new sell card gain = " + player.getSellResourceGain());
					player.setBuyResourceCost(
							Cost.reduceCost(player.getbuyResourceCost(), ((TradingCard) card).getReduceCost()));
					System.out.println(player.getName() + "'s new buy resource cost :" + player.getbuyResourceCost());
				}

				System.out.println(player.getName() + "'s new resources :" + player.getResourceCounter());
				return true;
			case "n":
				System.out.println("you've cenceled picked this card");
				return false;
			default:
				return false;
			}

		} else {
			return false;
		}

	}

	public static void sell(Card card, Player player) {
		player.setResourceCounter(
				Cost.addCost(player.getResourceCounter(), new Cost(0, 0, 0, 0, 0, player.getSellResourceGain())));
	}

	public static boolean buildPlace(PlaceCard card, Player player) throws PickCardFailException {
		if (card instanceof HaveChainSymbol && ChainSymbols.isHaveChainSymbol(player, (HaveChainSymbol) card)) {
			if (card instanceof HaveResource) {
				((HaveResource) card).addPlayerCounter(player);
			}
			if (card instanceof HavePoint) {
				((HavePoint) card).addPlayerPoint(player);
				System.out.println(player.getName() + "'s point :" + player.getplayerPoint());
			}
			if (card instanceof HaveChainSymbol) {
				((HaveChainSymbol) card).addChainSymbol(player);
				System.out.println(player.getName() + "'s Chain Symbols :" + player.getChainSymbols());
			}
			if (card instanceof Attackable) {
				((Attackable) card).attackPlayer(player);
				System.out.println("Attack!!");
				System.out.println("Attacker's position :" + AttackBoard.getPosition());
				if (player.getNum() == 1) {
					System.out.println(GameController.player2.getName()+"'s resources :"+GameController.player2.getResourceCounter());
				} else {
					System.out.println(GameController.player1.getName()+"'s resources :"+GameController.player1.getResourceCounter());
				}
			}
			System.out.println(player.getName() + "'s new resources :" + player.getResourceCounter());
			return true;
		}

		else if (Cost.checkCost(player.getResourceCounter(), card.getCost())) {
			if (card instanceof HaveResource) {
				((HaveResource) card).addPlayerCounter(player);
			}
			if (card instanceof HavePoint) {
				((HavePoint) card).addPlayerPoint(player);
				System.out.println(player.getName() + "'s point :" + player.getplayerPoint());
			}
			if (card instanceof HaveChainSymbol) {
				((HaveChainSymbol) card).addChainSymbol(player);
				System.out.println(player.getName() + "'s Chain Symbols :" + player.getChainSymbols());
			}
			if (card instanceof Attackable) {
				((Attackable) card).attackPlayer(player);
				System.out.println("Attack!!");
				System.out.println("Attacker's position :" + AttackBoard.getPosition());
				if (player.getNum() == 1) {
					System.out.println(GameController.player2.getName()+"'s resources :"+GameController.player2.getResourceCounter());
				} else {
					System.out.println(GameController.player1.getName()+"'s resources :"+GameController.player1.getResourceCounter());
				}
			}
			System.out.println(player.getName() + "'s new resources :" + player.getResourceCounter());
			return true;
		} else if (Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost()) <= player
				.getResourceCounter().getLMD()) {
			System.out.println(
					"spend " + Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost())
							+ " LMD to Build? [y/n]");
			switch (keyboard.nextLine()) {
			case "y":
				player.setResourceCounter(Cost.reduceCost(player.getResourceCounter(), new Cost(0, 0, 0, 0, 0,
						Cost.checkLmd(player.getResourceCounter(), card.getCost(), player.getbuyResourceCost()))));
				if (card instanceof HaveResource) {
					((HaveResource) card).addPlayerCounter(player);
				}
				if (card instanceof HavePoint) {
					((HavePoint) card).addPlayerPoint(player);
					System.out.println(player.getName() + "'s point :" + player.getplayerPoint());
				}
				if (card instanceof HaveChainSymbol) {
					((HaveChainSymbol) card).addChainSymbol(player);
					System.out.println(player.getName() + "'s Chain Symbols :" + player.getChainSymbols());
				}
				if (card instanceof Attackable) {
					((Attackable) card).attackPlayer(player);
					System.out.println("Attack!!");
					System.out.println("Attacker's position :" + AttackBoard.getPosition());
					if (player.getNum() == 1) {
						System.out.println(GameController.player2.getName()+"'s resources :"+GameController.player2.getResourceCounter());
					} else {
						System.out.println(GameController.player1.getName()+"'s resources :"+GameController.player1.getResourceCounter());
					}
				}

				System.out.println(player.getName() + "'s new resources :" + player.getResourceCounter());
				return true;
			case "n":
				System.out.println("you've cenceled picked this card");
				return false;
			default:
				return false;
			}

		} else {
			return false;
		}


	}

	public static void switchPlayerTurn() {
		if (playerTurn == 1) {
			playerTurn = 2;
		} else {
			playerTurn = 1;
		}
	}

	public int getPlayerTurn() {
		return this.playerTurn;
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

}
