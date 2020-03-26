package application;

import logic.AttackBoard;
import logic.Player;
import java.util.Scanner;

public class GameController {
	private static Scanner keyboard = new Scanner(System.in) ;
	//Game initialize
	InitialCardDeck intitialCardDeck = new InitialCardDeck() ;
	static Player player1 = new Player(1);
	static Player player2 = new Player(2);	
	static AttackBoard ATKboard = new AttackBoard();
	public static void main(String args[]) {
		//set player name
		System.out.println("=====Start Game=====");
		System.out.println("please input player1 name");
		String playeOneName = keyboard.nextLine();
		player1.setName(playeOneName);
		System.out.println("Player1 : "+player1.getName());
		System.out.println(player1.getName()+"'s resources :"+player1.getResourceCounter());
		System.out.println("please input player2 name");
		String playeTwoName = keyboard.nextLine();
		player2.setName(playeTwoName);
		System.out.println("Player2 : "+player2.getName());
		System.out.println(player2.getName()+"'s resources :"+player2.getResourceCounter());
		System.out.println("=====let's Start!!=====");
		
		
		
		
		
		
		
	}
}
