package application;

import logic.AttackBoard;
import logic.MainBoard;
import logic.PlaceBoard;
import logic.Player;
import logic.Turn;


public class GameController {
	private static int phase;
	public static final InitialCardDeck INITIALCARDDECK = new InitialCardDeck();
	public static final InitialPlaceCard PLACECARDDECK = new InitialPlaceCard();
	public static Player player1 = new Player(1);
	public static Player player2 = new Player(2);
	public static AttackBoard ATKboard = new AttackBoard();
	public static MainBoard mainBoard = new MainBoard();
	public static PlaceBoard placeBoard = new PlaceBoard();
	public static boolean endGame = false;

	public static void initializeGame() {
		GameController.mainBoard.addCardOnBoard(GameController.INITIALCARDDECK, 1);
		GameController.mainBoard.addCardOnBoard(GameController.INITIALCARDDECK, 2);
		GameController.mainBoard.addCardOnBoard(GameController.INITIALCARDDECK, 3);
		GameController.mainBoard.firstUpdateCardOnBoard(1);
		GameController.mainBoard.firstUpdateCardOnBoard(2);
		GameController.mainBoard.firstUpdateCardOnBoard(3);
		GameController.mainBoard.updateCardOnBoard(1);
		GameController.mainBoard.updateCardOnBoard(2);
		GameController.mainBoard.updateCardOnBoard(3);
		GameController.placeBoard.addCardOnBoard(GameController.PLACECARDDECK.placeCardDeck);
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
