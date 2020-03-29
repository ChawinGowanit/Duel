package Test.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Card.RawMaterialCard;
import Card.base.Cost;
import logic.Player;

public class TestRawMaterialCard {
	Player P1;

	@Test
	public void testCardConstructor() {
		RawMaterialCard card = new RawMaterialCard("testName", new Cost(), new Cost());
		assertEquals("testName", card.getName());
		assertEquals(new Cost().toString(), card.getCost().toString());
		assertEquals(new Cost().toString(), card.getResource().toString());
	}
	@Test 
	public void testAddResourceCounter() {
		P1 = new Player(1);
		RawMaterialCard card = new RawMaterialCard("testName", new Cost(), new Cost(1,1,1,1,1,1));
		card.addPlayerCounter(P1);
		assertEquals(new Cost(1,1,1,1,1,8).toString(), P1.getResourceCounter().toString());
		RawMaterialCard card1 = new RawMaterialCard("testName", new Cost(), new Cost(2,3,4,5,6,7));
		card1.addPlayerCounter(P1);
		assertEquals(new Cost(3,4,5,6,7,15).toString(), P1.getResourceCounter().toString());

	}

}
