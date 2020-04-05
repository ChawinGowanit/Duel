package Test.card.base;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Card.TradingCard;
import Card.base.ChainSymbols;
import Card.base.Cost;
import logic.Player;

public class TestChainSymbols {
	@Test
	public void testConstructor() {
		ChainSymbols test1 = new ChainSymbols();
		ChainSymbols test2 = new ChainSymbols("testChainSymbols");
		ChainSymbols test3 = new ChainSymbols("testChainSymbols1", "testChainSymbols2");
		assertEquals(new ArrayList<String>(), test1.getChainSymbol());
		ArrayList<String> check = new ArrayList<String>();
		check.add("testChainSymbols");
		assertEquals(check, test2.getChainSymbol());
		ArrayList<String> check1 = new ArrayList<String>();
		check1.add("testChainSymbols1");
		check1.add("testChainSymbols2");
		assertEquals(check1, test3.getChainSymbol());
	}

	@Test
	public void testAddChainSymbols() {
		ChainSymbols test = new ChainSymbols();
		test.addChainSymbols("test1");
		ArrayList<String> check = new ArrayList<String>();
		check.add("test1");
		assertEquals(check, test.getChainSymbol());
		test.addChainSymbols("test2");
		check.add("test2");
		assertEquals(check, test.getChainSymbol());
	}

	@Test
	public void testAddExistingChainSymbols() {
		ChainSymbols test = new ChainSymbols();
		test.addChainSymbols("test1");
		ArrayList<String> check = new ArrayList<String>();
		check.add("test1");
		test.addChainSymbols("test1");
		assertEquals(check, test.getChainSymbol());

	}

	@Test
	public void testIsHaveChainSymbols() {
		TradingCard card = new TradingCard("testName", new Cost(), new ChainSymbols(), new Cost(), new Cost(), 0);
		Player P1 = new Player(1);
		assertEquals(false, ChainSymbols.isHaveChainSymbol(P1, card));
		P1.addChainSymbol("test1");
		assertEquals(false, ChainSymbols.isHaveChainSymbol(P1, card));
		TradingCard card1 = new TradingCard("testName", new Cost(), new ChainSymbols("test2"), new Cost(), new Cost(),
				0);
		assertEquals(false, ChainSymbols.isHaveChainSymbol(P1, card1));
		TradingCard card2 = new TradingCard("testName", new Cost(), new ChainSymbols("test2", "test1"), new Cost(),
				new Cost(), 0);
		assertEquals(true, ChainSymbols.isHaveChainSymbol(P1, card2));
		P1.addChainSymbol("test2");
		assertEquals(true, ChainSymbols.isHaveChainSymbol(P1, card2));
	}
}
