package Test.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Card.PlaceCard;
import Card.base.Cost;
import application.InitialPlaceCard;
import logic.PlaceBoard;
import logic.Player;


public class TestPlaceBoard {
	PlaceBoard placeBoardPlayerTest;
	InitialPlaceCard initialPlaceCard;
	
	
	@Before
	public void setUp() {
		initialPlaceCard = new InitialPlaceCard() ;
		placeBoardPlayerTest = new PlaceBoard();
	}
	@Test
	public void testConstructor() {
		placeBoardPlayerTest = new PlaceBoard();
		ArrayList<PlaceCard> test1 = new ArrayList<PlaceCard>();
		PlaceBoard placeBoardPlayerTest = new PlaceBoard();
		assertEquals(test1,placeBoardPlayerTest.getPlaceListPlayer1());
		
		
		
	}
	
	@Test
	public void  testAddCardOnBoard() {
		placeBoardPlayerTest.addCardOnBoard(initialPlaceCard.getPlaceCardDeck());
		assertEquals(0,placeBoardPlayerTest.getCardOnBoard().get(0).getPosition());
		assertEquals(1,placeBoardPlayerTest.getCardOnBoard().get(1).getPosition());
		assertEquals(2,placeBoardPlayerTest.getCardOnBoard().get(2).getPosition());
		assertEquals(3,placeBoardPlayerTest.getCardOnBoard().get(3).getPosition());
		assertEquals(4,placeBoardPlayerTest.getCardOnBoard().get(4).getPosition());
		assertEquals(5,placeBoardPlayerTest.getCardOnBoard().get(5).getPosition());
		assertEquals(6,placeBoardPlayerTest.getCardOnBoard().get(6).getPosition());
		assertEquals(7,placeBoardPlayerTest.getCardOnBoard().get(7).getPosition());
		
		assertEquals("Bar",placeBoardPlayerTest.getCardOnBoard().get(0).getName());
		assertEquals("Hotel",placeBoardPlayerTest.getCardOnBoard().get(1).getName());
		assertEquals("Lungman's Command Center",placeBoardPlayerTest.getCardOnBoard().get(2).getName());
		assertEquals("Lungman's Uptown",placeBoardPlayerTest.getCardOnBoard().get(3).getName());
		assertEquals("Rhodes Island",placeBoardPlayerTest.getCardOnBoard().get(4).getName());
		assertEquals("Rhodes Island's server room",placeBoardPlayerTest.getCardOnBoard().get(5).getName());
		assertEquals("Rhodes Island's infirmary",placeBoardPlayerTest.getCardOnBoard().get(6).getName());
		assertEquals("Victirian Mounted Cave",placeBoardPlayerTest.getCardOnBoard().get(7).getName());
		
		
	}
	
	@Test
	
	public void testConstruction() {
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		
		placeBoardPlayerTest.construction(player1, new PlaceCard("Bar", 0, 6, new Cost(1, 1, 0, 0, 2, 0), new Cost()));
		assertEquals("Bar",placeBoardPlayerTest.getPlaceListPlayer1().get(0).getName());
		
		placeBoardPlayerTest.construction(player2, new PlaceCard("Lungman's Uptown", 2, 3, new Cost(3, 0, 0, 0, 1, 0), new Cost()));
		assertEquals("Lungman's Uptown",placeBoardPlayerTest.getPlaceListPlayer2().get(0).getName());
	}
	
	@Test
	
	public void testGetPlaceCardFromName() {
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		placeBoardPlayerTest.addCardOnBoard(initialPlaceCard.placeCardDeck);
		placeBoardPlayerTest.construction(player1, new PlaceCard("Bar", 0, 6, new Cost(1, 1, 0, 0, 2, 0), new Cost()));
		assertEquals("Bar",placeBoardPlayerTest.getPlaceListPlayer1().get(0).getName());
		placeBoardPlayerTest.construction(player2, new PlaceCard("Lungman's Uptown", 2, 3, new Cost(3, 0, 0, 0, 1, 0), new Cost()));
		assertEquals("Lungman's Uptown",placeBoardPlayerTest.getPlaceListPlayer2().get(0).getName());
		assertEquals(new PlaceCard("Lungman's Uptown", 2, 3, new Cost(3, 0, 0, 0, 1, 0), new Cost()).toString(),placeBoardPlayerTest.getPlaceCardFromName("Lungman's Uptown").toString());
		assertEquals(new PlaceCard("Hotel", 0, 3, new Cost(0, 0, 2, 1, 1, 0), new Cost(0, 0, 0, 0, 0, 3)).toString(),placeBoardPlayerTest.getPlaceCardFromName("Hotel").toString());
	}
	
	
	@Test
	
	public void testRemoveCardFromBoard() {
		initialPlaceCard = new InitialPlaceCard() ;
		placeBoardPlayerTest = new PlaceBoard();
		placeBoardPlayerTest.addCardOnBoard(initialPlaceCard.placeCardDeck);
		placeBoardPlayerTest.removeCardFromBoard(new PlaceCard("Bar", 0, 6, new Cost(1, 1, 0, 0, 2, 0), new Cost()), 1);
		PlaceCard blankPlace = new PlaceCard("", 0, 0, new Cost(), new Cost()) ;		
		assertEquals(blankPlace.toString(),placeBoardPlayerTest.getCardOnBoard().get(0).toString());
	}

}
