package testlogic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Card.PlaceCard;
import application.InitialPlaceCard;
import logic.PlaceBoard;


public class testPlaceBoard {
	PlaceBoard placeBoardPlayerTest;
	InitialPlaceCard placeCardDeck;
	
	
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
		placeBoardPlayerTest.addCardOnBoard(placeCardDeck);
	}

}
