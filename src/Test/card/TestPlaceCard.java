package Test.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Card.PlaceCard;
import Card.base.Cost;
import logic.AttackBoard;
import logic.Player;

public class TestPlaceCard {
	Player P1 ;
	Player P2 ;
	@Test
	public void testCardConstructor() {
		PlaceCard card = new PlaceCard("testName", 3,3,new Cost(),new Cost()) ;
		assertEquals("testName", card.getName());
		assertEquals(3, card.getPlayerPoint());
		assertEquals(3, card.getAttackPoint());
		assertEquals(new Cost().toString(), card.getCost().toString());
		assertEquals(new Cost().toString(), card.getResource().toString());
	}
	@Test
	public void testAttackPointLessThanZero() {
		PlaceCard card = new PlaceCard("testName", -3,3,new Cost(),new Cost()) ;
		assertEquals(0, card.getAttackPoint());
	}
	@Test
	public void testPointLessThanZero() {
		PlaceCard card = new PlaceCard("testName", 3,-3,new Cost(),new Cost()) ;
		assertEquals(0, card.getPlayerPoint());

	}
	public void testAttackPlayer() {
		P1 = new Player(1);
		P2 = new Player(2);
		AttackBoard attackBoard = new AttackBoard() ;
		PlaceCard card = new PlaceCard("testName", 3, 3,new Cost(),new Cost());
		card.attackPlayer(P1);
		assertEquals(1, attackBoard.getPosition());
	}
	@Test
	public void testAddPlayerPoint() {
		P1 = new Player(1);
		PlaceCard card = new PlaceCard("testName", 3, 3,new Cost(),new Cost()) ;
		card.addPlayerPoint(P1);
		assertEquals(3, P1.getplayerPoint());
		PlaceCard card1 = new PlaceCard("testName", 3, 6,new Cost(),new Cost()) ;
		card1.addPlayerPoint(P1);
		assertEquals(9, P1.getplayerPoint());
	}
	@Test 
	public void testAddPlayerCounter() {
		P1 = new Player(1);
		PlaceCard card = new PlaceCard("testName", 3, 3,new Cost(),new Cost(1,1,1,1,1,1)) ;
		card.addPlayerCounter(P1);
		assertEquals(new Cost(1,1,1,1,1,8).toString(), P1.getResourceCounter().toString());
		PlaceCard card1 = new PlaceCard("testName", 3, 3,new Cost(),new Cost(2,3,4,5,6,7)) ;;
		card1.addPlayerCounter(P1);
		assertEquals(new Cost(3,4,5,6,7,15).toString(), P1.getResourceCounter().toString());

	}
}
