package testlogic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Card.PlaceCard;
import Card.base.Cost;
import application.InitialPlaceCard;
import logic.PlaceBoard;
import logic.Player;


public class testPlaceBoard {
	PlaceBoard placeBoardPlayerTest;
	InitialPlaceCard initialPlaceCard;
	
	
	@Before
	public void setUp() {
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
		assertEquals(0,PlaceBoard.getCardOnBoard().get(0).getPosition());
		assertEquals(1,PlaceBoard.getCardOnBoard().get(1).getPosition());
		assertEquals(2,PlaceBoard.getCardOnBoard().get(2).getPosition());
		assertEquals(3,PlaceBoard.getCardOnBoard().get(3).getPosition());
		assertEquals(4,PlaceBoard.getCardOnBoard().get(4).getPosition());
		assertEquals(5,PlaceBoard.getCardOnBoard().get(5).getPosition());
		assertEquals(6,PlaceBoard.getCardOnBoard().get(6).getPosition());
		assertEquals(7,PlaceBoard.getCardOnBoard().get(7).getPosition());
		
		assertEquals("Bar",PlaceBoard.getCardOnBoard().get(0).getName());
		assertEquals("Hotel",PlaceBoard.getCardOnBoard().get(1).getPosition());
		assertEquals("Lungman's Command Center",PlaceBoard.getCardOnBoard().get(2).getPosition());
		assertEquals("Lungman's Uptown",PlaceBoard.getCardOnBoard().get(3).getPosition());
		assertEquals("Rhodes Island",PlaceBoard.getCardOnBoard().get(4).getPosition());
		assertEquals("Rhodes Island's server room",PlaceBoard.getCardOnBoard().get(5).getPosition());
		assertEquals("Rhodes Island's infirmary",PlaceBoard.getCardOnBoard().get(6).getPosition());
		assertEquals("Victirian Mounted Cave",PlaceBoard.getCardOnBoard().get(7).getPosition());
		
		
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
		assertEquals(new PlaceCard("Lungman's Uptown", 2, 3, new Cost(3, 0, 0, 0, 1, 0), new Cost()),placeBoardPlayerTest.getPlaceCardFromName("Lungman's Uptown"));
		assertEquals(new PlaceCard("Hotel", 0, 3, new Cost(0, 0, 2, 1, 1, 0), new Cost(0, 0, 0, 0, 0, 3)),placeBoardPlayerTest.getPlaceCardFromName("Hotel"));
	}
	
	
	@Test
	
	public void testRemoveCardFromBoard() {
		placeBoardPlayerTest.removeCardFromBoard(new PlaceCard("Lungman's Uptown", 2, 3, new Cost(3, 0, 0, 0, 1, 0), new Cost()), 1);
		PlaceCard blankPlace = new PlaceCard("", 0, 0, new Cost(), new Cost()) ;		
		assertEquals(blankPlace,PlaceBoard.getCardOnBoard().get(3));
	}

}
