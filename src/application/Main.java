package application;

import logic.Turn;
import logic.exception.PickCardFailException;

import java.util.Scanner;

import Card.base.Cost;

public class Main {

	public static void main(String args[]) throws PickCardFailException {
		Scanner keyboard = new Scanner(System.in);
		// set player name
		System.out.println("=====Start Game=====");
		System.out.println("please input player1 name");
		String playeOneName = keyboard.nextLine();
		GameController.player1.setName(playeOneName);
		System.out.println("Player1 : " + GameController.player1.getName());
		System.out.println(
				GameController.player1.getName() + "'s resources :" + GameController.player1.getResourceCounter());
		System.out.println("please input player2 name");
		String playeTwoName = keyboard.nextLine();
		GameController.player2.setName(playeTwoName);
		System.out.println("Player2 : " + GameController.player2.getName());
		System.out.println(
				GameController.player2.getName() + "'s resources :" + GameController.player2.getResourceCounter());

		GameController.InitializeGame(); // addCardOnBoard 3 phase and firstUpdate

		while (!GameController.endGame || (GameController.ATKboard.getPosition() == 9)
				|| GameController.ATKboard.getPosition() == -9) {
			if (Turn.getPlayerTurn() == 1) {
				System.out.println("-----" + GameController.player1.getName() + "'s Turn" + "-----");
			} else {
				System.out.println("-----" + GameController.player2.getName() + "'s Turn" + "-----");
			}
			GameController.mainBoard.updateCardOnBoard(GameController.getPhase());
			System.out.println(GameController.placeBoard.getPlaceCardOnBoard());
			System.out.println(GameController.mainBoard.getCardOnBoard(GameController.getPhase()));
			System.out.println("Type card you want to pick");
			String card = keyboard.nextLine();
			try {
				Turn.setSelectedCard(GameController.mainBoard.getCardFromName(card, GameController.getPhase()));
				System.out.println("select action [build,sell,buildPlace]:");
				String action = keyboard.nextLine();

				switch (action) {
				case "build":
					if (Turn.buildController()) {
						System.out.println("Spend "
								+ Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
										Turn.getSelectedCard().getCost(),
										GameController.getCurrentPlayer().getbuyResourceCost())
								+ " LMD to build? [y/n]");
						String respond = keyboard.nextLine();
						switch (respond) {
						case "y":
							Turn.build();
							break;
						case "n":
							break;
						default:
							System.out.println("Invalid answer");
						}
					} else {
						System.out.println("Selected Card Insufficient Material");
					}
					break;
				case "sell":
					Turn.sell();
					break;
				case "buildPlace":
					System.out.println("Type Place you want to build");
					String placeCard = keyboard.nextLine();
					Turn.setSelectedPlaceCard(GameController.placeBoard.getPlaceCardFromName(placeCard));
					if (Turn.buildPlaceController()) {
						System.out
								.println("Spend "
										+ Cost.checkLmd(GameController.getCurrentPlayer().getResourceCounter(),
												Turn.getSelectedPlaceCard().getCost(),
												GameController.getCurrentPlayer().getbuyResourceCost())
										+ "LMD to build?");
						String respond = keyboard.nextLine();
						switch (respond) {
						case "y":
							Turn.buildPlace();
							break;
						case "n":
							break;
						default:
							System.out.println("Invalid answer");
						}
					} else {
						System.out.println("Selected Card Insufficient Material");
					}
					break;
				}
				switch (GameController.getPhase()) {
				case 1: // phase1
					if (GameController.mainBoard.checkIfAllBlankCard(GameController.mainBoard.getCardOnBoard(1))) {
						GameController.setPhase(2);
						System.out.println("=====Phase 2 Start!=====");
					}
					break;
				case 2: // phase 2
					if (GameController.mainBoard.checkIfAllBlankCard(GameController.mainBoard.getCardOnBoard(2))) {
						GameController.setPhase(3);
						System.out.println("=====Phase 3 Start!=====");
					}
					break;
				case 3: // phase 3
					if (GameController.mainBoard.checkIfAllBlankCard(GameController.mainBoard.getCardOnBoard(3))) {
						GameController.endGame = true;
						System.out.println("=====The game has end=====");
						if (GameController.player1.getplayerPoint() > GameController.player2.getplayerPoint()) {
							System.out.println(GameController.player1.getName() + " WIN!");
						} else if (GameController.player1.getplayerPoint() < GameController.player2.getplayerPoint()) {
							System.out.println(GameController.player2.getName() + " WIN!");
						} else {
							System.out.println(GameController.player1.getName() + " and "
									+ GameController.player2.getName() + " TIE!");
						}
					}
				default:
					break;
				}
				if (GameController.ATKboard.getPosition() == 9) {
					System.out.println("=====The game has end=====");
					System.out.println(GameController.player1.getName() + " WIN!");
				} else if (GameController.ATKboard.getPosition() == -9){
					System.out.println("=====The game has end=====");
					System.out.println(GameController.player1.getName() + " WIN!");
				}
			} catch (PickCardFailException e) {
				System.out.println(e.message);
			}
		}
	}

}
