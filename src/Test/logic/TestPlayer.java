package test.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Card.base.Cost;
import logic.Player;

public class TestPlayer {
	Player player1;
	Player player2;
	
	@Before
	public void setup() {
		player1 = new Player(1);
		player2 = new Player(2);
	}
	
	
	@Test
	public void testConstructor() {
		assertEquals(1, player1.getNum());
		assertEquals(2, player2.getNum());
		
		
		assertEquals(new Cost(0,0,0,0,0,7).toString(), player1.getResourceCounter().toString());
		assertEquals(new Cost(0,0,0,0,0,7).toString(), player2.getResourceCounter().toString());
		
		
		assertEquals(new Cost(2,2,2,2,2,1).toString(), player1.getbuyResourceCost().toString());
		assertEquals(new Cost(2,2,2,2,2,1).toString(), player2.getbuyResourceCost().toString());
		
		
		assertEquals(0, player1.getplayerPoint());
		assertEquals(0, player2.getplayerPoint());
		
		assertEquals(2, player1.getSellResourceGain());
		assertEquals(2, player2.getSellResourceGain());
	}
	
	@Test
	public void testSetName() {
		player1.setName("test1");
		assertEquals("test1", player1.getName());
		
		player2.setName("test2");
		assertEquals("test2", player2.getName());
	}
	
	@Test
	public void testIncreasePlayerPoint() {
		player1.increasePlayerPoint(5);
		assertEquals(5, player1.getplayerPoint());
		
		player2.increasePlayerPoint(20);
		assertEquals(20, player2.getplayerPoint());
		
	}
}
