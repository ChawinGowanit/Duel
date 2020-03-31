package test.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Card.TradingCard;
import Card.base.ChainSymbols;
import Card.base.Cost;
import logic.Player;

public class TestTradingCard {
	Player P1;

	@Test
	public void testCardConstructor() {
		TradingCard card = new TradingCard("testName", new Cost(), new ChainSymbols(), new Cost(),
				new Cost(0, 0, 0, 0, 1, 0), 10);
		assertEquals(new Cost().toString(), card.getCost().toString());
		assertEquals("testName", card.getName());
		assertEquals(10, card.getPoint());
		assertEquals(new ChainSymbols().toString(), card.getChainSymbols().toString());
		assertEquals(new Cost(0, 0, 0, 0, 1, 0).toString(), card.getReduceCost().toString());
	}
	@Test
	public void testPointLessThanZero() {
		TradingCard card = new TradingCard("testName", new Cost(), new ChainSymbols(), new Cost(),
				new Cost(0, 0, 0, 0, 1, 0), -10);
		assertEquals(0, card.getPoint());

	}

	@Test
	public void testAddChainSymbols() {
		P1 = new Player(1);
		TradingCard card = new TradingCard("testName", new Cost(),
				new ChainSymbols("testChainSymbol1", "tesChainSymbol2"), new Cost(0, 0, 0, 0, 1, 0), new Cost(), 10);
		card.addChainSymbol(P1);
		assertEquals(new ChainSymbols("testChainSymbol1", "tesChainSymbol2").toString(),
				P1.getChainSymbols().toString());
		TradingCard card1 = new TradingCard("testName", new Cost(), new ChainSymbols("testChainSymbol3"),
				new Cost(0, 0, 0, 0, 1, 0), new Cost(), 10);
		card1.addChainSymbol(P1);
		ChainSymbols chainSymbols = new ChainSymbols("testChainSymbol1", "tesChainSymbol2");
		chainSymbols.addChainSymbols("testChainSymbol3");
		assertEquals(chainSymbols.toString(), P1.getChainSymbols().toString());

	}
	@Test 
	public void testAddResourceCounter() {
		P1 = new Player(1);
		TradingCard card = new TradingCard("testName", new Cost(), new ChainSymbols(), new Cost(1,1,1,1,1,1),
				new Cost(), 0 );
		card.addPlayerCounter(P1);
		assertEquals(new Cost(1,1,1,1,1,8).toString(), P1.getResourceCounter().toString());
		TradingCard card1 = new TradingCard("testName",new Cost(), new ChainSymbols(), new Cost(2,3,4,5,6,7),
				new Cost(), 0 );
		card1.addPlayerCounter(P1);
		assertEquals(new Cost(3,4,5,6,7,15).toString(), P1.getResourceCounter().toString());

	}
	@Test
	public void testReducePlayerBuyResourceCost() {
		P1 = new Player(1);
		TradingCard card = new TradingCard("testName", new Cost(), new ChainSymbols(), new Cost(),
				new Cost(1,0,0,0,0,0), 0 );
		card.reducePlayerBuyResourceCost(P1);
		assertEquals(new Cost(1,2,2,2,2,1).toString(), P1.getbuyResourceCost().toString());
		TradingCard card1 = new TradingCard("testName", new Cost(), new ChainSymbols(), new Cost(),
				new Cost(0,0,0,2,0,0), 0 );
		card1.reducePlayerBuyResourceCost(P1);
		assertEquals(new Cost(1,2,2,0,2,1).toString(), P1.getbuyResourceCost().toString());
	}
	@Test
	public void testAddPlayerPoint() {
		P1 = new Player(1);
		TradingCard card = new TradingCard("testName", new Cost(), new ChainSymbols(), new Cost(),
				new Cost(), 3 );
		card.addPlayerPoint(P1);
		assertEquals(3, P1.getplayerPoint());
		TradingCard card1 = new TradingCard("testName", new Cost(), new ChainSymbols(), new Cost(),
				new Cost(), 10 );
		card1.addPlayerPoint(P1);
		assertEquals(13, P1.getplayerPoint());
	}
}
