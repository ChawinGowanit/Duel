package application;

import logic.AttackBoard;
import logic.MainBoard;
import logic.PickCardFailException;
import logic.PlaceBoard;
import logic.Player;
import logic.Turn;

import java.util.ArrayList;
import java.util.Scanner;

import Card.PlaceCard;
import Card.base.Card;

public class GameController {
	private static int phase;
	private static Scanner keyboard = new Scanner(System.in);
	static InitialCardDeck initialCardDeck = new InitialCardDeck();
	static InitialPlaceCard placeCardDeck = new InitialPlaceCard();
	public static Player player1 = new Player(1);
	public static Player player2 = new Player(2);
	public static AttackBoard ATKboard = new AttackBoard();
	public static MainBoard mainBoard = new MainBoard();
	public static PlaceBoard placeBoard = new PlaceBoard();
	static Turn turn = new Turn();

	public static void main(String args[]) throws PickCardFailException {
		// set player name
		System.out.println("=====Start Game=====");
		System.out.println("please input player1 name");
		String playeOneName = keyboard.nextLine();
		player1.setName(playeOneName);
		System.out.println("Player1 : " + player1.getName());
		System.out.println(player1.getName() + "'s resources :" + player1.getResourceCounter());
		System.out.println("please input player2 name");
		String playeTwoName = keyboard.nextLine();
		player2.setName(playeTwoName);
		System.out.println("Player2 : " + player2.getName());
		System.out.println(player2.getName() + "'s resources :" + player2.getResourceCounter());
		System.out.println("=====let's Start!!=====");
		mainBoard.addCardOnBoard(initialCardDeck, 1);
		mainBoard.addCardOnBoard(initialCardDeck, 2);
		mainBoard.addCardOnBoard(initialCardDeck, 3);
		mainBoard.firstUpdateCardOnBoard(1);
		mainBoard.firstUpdateCardOnBoard(2);
		mainBoard.firstUpdateCardOnBoard(3);
		placeBoard.addCardOnBoard(placeCardDeck.placeCardDeck);
		phase = 1;
		System.out.println("=====Phase 1 Start!=====");
		for (Card card : mainBoard.getStartingCardOnBoard()) {
			if (turn.getPlayerTurn() == 1) {
				System.out.println("-----" + player1.getName() + "'s Turn" + "-----");
			} else {
				System.out.println("-----" + player2.getName() + "'s Turn" + "-----");
			}
			mainBoard.updateCardOnBoard(1);
			System.out.println(placeBoard.getPlaceCardOnBoard());
			System.out.println(mainBoard.getStartingCardOnBoard());
			System.out.println("Type card you want to pick");
			String respond = keyboard.nextLine();
			Turn.turnConTroller(mainBoard.getCardFromName(respond, mainBoard.getStartingCardOnBoard()), 1);
			mainBoard.updateCardOnBoard(1);
		}

		phase = 2;
		System.out.println("=====Phase 2 Start!=====");
		for (Card card : mainBoard.getMidGameCardOnBoard()) {
			if (turn.getPlayerTurn() == 1) {
				System.out.println("-----" + player1.getName() + "'s Turn" + "-----");
			} else {
				System.out.println("-----" + player2.getName() + "'s Turn" + "-----");
			}
			mainBoard.updateCardOnBoard(2);
			System.out.println(placeBoard.getPlaceCardOnBoard());
			System.out.println(mainBoard.getMidGameCardOnBoard());
			System.out.println("Type card you want to pick");
			String respond = keyboard.nextLine();
			Turn.turnConTroller(mainBoard.getCardFromName(respond, mainBoard.getMidGameCardOnBoard()), 2);
			mainBoard.updateCardOnBoard(2);
		}
		phase = 3;
		System.out.println("=====Phase 3 Start!=====");
		for (Card card : mainBoard.getLateGameCardOnBoard()) {
			if (turn.getPlayerTurn() == 1) {
				System.out.println("-----" + player1.getName() + "'s Turn" + "-----");
			} else {
				System.out.println("-----" + player2.getName() + "'s Turn" + "-----");
			}
			mainBoard.updateCardOnBoard(3);
			System.out.println(placeBoard.getPlaceCardOnBoard());
			System.out.println(mainBoard.getLateGameCardOnBoard());
			System.out.println("Type card you want to pick");
			String respond = keyboard.nextLine();
			Turn.turnConTroller(mainBoard.getCardFromName(respond, mainBoard.getLateGameCardOnBoard()), 3);
			mainBoard.updateCardOnBoard(3);
		}

		System.out.println("=====The game has end=====");
		if (player1.getplayerPoint() > player2.getplayerPoint()) {
			System.out.println(player1.getName() + " WIN!");
		} else if (player1.getplayerPoint() < player2.getplayerPoint()) {
			System.out.println(player2.getName() + " WIN!");
		} else {
			System.out.println(player1.getName() + " and " + player2.getName() + " TIE!");
		}

	}

	public static int getPhase() {
		return phase;
	}
}
