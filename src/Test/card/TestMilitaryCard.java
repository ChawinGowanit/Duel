package Test.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Card.MilitaryCard;
import Card.base.ChainSymbols;
import Card.base.Cost;
import logic.AttackBoard;
import logic.Player;

public class TestMilitaryCard {
	Player P1;
	Player P2;
	AttackBoard attackBoard ;
	@Test
	public void testCardConstructor() {
		MilitaryCard card = new MilitaryCard("testName", new Cost(), 10, new ChainSymbols());
		assertEquals(new Cost().toString(), card.getCost().toString());
		assertEquals("testName", card.getName());
		assertEquals(10, card.getAttackPoint());
		assertEquals(new ChainSymbols().toString(), card.getChainSymbols().toString());
	}

	@Test
	public void testAttackPointLessThanZero() {
		MilitaryCard card = new MilitaryCard("testName", new Cost(), -1, new ChainSymbols());
		assertEquals(0, card.getAttackPoint());
	}
	@Test
	public void testAttackPlayer() {
		P1 = new Player(1);
		P2 = new Player(2);
		attackBoard=  new AttackBoard() ;
		MilitaryCard card = new MilitaryCard("testName", new Cost(), 1, new ChainSymbols());
		card.attackPlayer(P1);
		assertEquals(1, attackBoard.getPosition());
	}
	@Test
	public void testAddChainSymbols() {
		P1 = new Player(1);
		MilitaryCard card = new MilitaryCard("testName", new Cost(), 1, new ChainSymbols("testChainSymbol1","tesChainSymbol2"));
		card.addChainSymbol(P1);
		assertEquals(new ChainSymbols("testChainSymbol1","tesChainSymbol2").toString(), P1.getChainSymbols().toString());
		MilitaryCard card1 = new MilitaryCard("testName", new Cost(), 1, new ChainSymbols("testChainSymbol3"));
		card1.addChainSymbol(P1);
		ChainSymbols chainSymbols = new ChainSymbols("testChainSymbol1","tesChainSymbol2") ;
		chainSymbols.addChainSymbols("testChainSymbol3");
		assertEquals(chainSymbols.toString(), P1.getChainSymbols().toString());

	}
}
