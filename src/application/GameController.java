package application;

import logic.AttackBoard;
import logic.MainBoard;
import logic.PlaceBoard;
import logic.Player;
import logic.Turn;


public class GameController {
	private static int phase;
	public static InitialCardDeck initialCardDeck = new InitialCardDeck();
	public static InitialPlaceCard placeCardDeck = new InitialPlaceCard();
	public static Player player1 = new Player(1);
	public static Player player2 = new Player(2);
	public static AttackBoard ATKboard = new AttackBoard();
	public static MainBoard mainBoard = new MainBoard();
	public static PlaceBoard placeBoard = new PlaceBoard();
	public static boolean endGame = false;

	public static void InitializeGame() {
		GameController.mainBoard.addCardOnBoard(GameController.initialCardDeck, 1);
		GameController.mainBoard.addCardOnBoard(GameController.initialCardDeck, 2);
		GameController.mainBoard.addCardOnBoard(GameController.initialCardDeck, 3);
		GameController.mainBoard.firstUpdateCardOnBoard(1);
		GameController.mainBoard.firstUpdateCardOnBoard(2);
		GameController.mainBoard.firstUpdateCardOnBoard(3);
		GameController.mainBoard.updateCardOnBoard(1);
		GameController.mainBoard.updateCardOnBoard(2);
		GameController.mainBoard.updateCardOnBoard(3);
		GameController.placeBoard.addCardOnBoard(GameController.placeCardDeck.placeCardDeck);
		GameController.setPhase(1);
	}

	public static int getPhase() {
		return phase;
	}

	public static void setPhase(int i) {
		// TODO Auto-generated method stub
		phase = i;
	}

	public static Player getCurrentPlayer() {
		if (Turn.getPlayerTurn() == 1) {
			return player1;
		} else {
			return player2;
		}
	}
}
