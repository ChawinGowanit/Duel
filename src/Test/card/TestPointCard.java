package Test.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Card.PointCard;
import Card.base.ChainSymbols;
import Card.base.Cost;
import logic.Player;

public class TestPointCard {
	Player P1;
	@Test
	public void testConstructor() {
		PointCard card = new PointCard("testName",new Cost(),10,new ChainSymbols());
		assertEquals("testName", card.getName());
		assertEquals(new Cost().toString(), card.getCost().toString());
		assertEquals(10, card.getPlayerPoint());
		assertEquals(new ChainSymbols().toString(), card.getChainSymbols().toString());
	}
	@Test
	public void testPointLessThanZero() {
		PointCard card = new PointCard("testName",new Cost(),-1,new ChainSymbols());
		assertEquals(0, card.getPlayerPoint());

	}
	@Test
	public void testAddChainSymbols() {
		P1 = new Player(1);
		PointCard card = new PointCard("testName", new Cost(), 1, new ChainSymbols("testChainSymbol1","tesChainSymbol2"));
		card.addChainSymbol(P1);
		assertEquals(new ChainSymbols("testChainSymbol1","tesChainSymbol2").toString(), P1.getChainSymbols().toString());
		PointCard card1 = new PointCard("testName", new Cost(), 1, new ChainSymbols("testChainSymbol3"));
		card1.addChainSymbol(P1);
		ChainSymbols chainSymbols = new ChainSymbols("testChainSymbol1","tesChainSymbol2") ;
		chainSymbols.addChainSymbols("testChainSymbol3");
		assertEquals(chainSymbols.toString(), P1.getChainSymbols().toString());
	}
	@Test
	public void testAddPlayerPoint() {
		P1 = new Player(1);
		PointCard card = new PointCard("testName", new Cost(), -6, new ChainSymbols("testChainSymbol1","tesChainSymbol2"));
		card.addPlayerPoint(P1);
		assertEquals(0, P1.getplayerPoint());
		PointCard card1 = new PointCard("testName", new Cost(), 20, new ChainSymbols("testChainSymbol3"));
		card1.addPlayerPoint(P1);
		assertEquals(20, P1.getplayerPoint());


	}
}
