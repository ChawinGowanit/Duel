package testlogic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Card.MilitaryCard;
import Card.base.ChainSymbols;
import Card.base.Cost;
import logic.AttackBoard;
import logic.Player;

public class testAttackBoard {
	AttackBoard attackTest;
	MilitaryCard testMilitaryCard;
	MilitaryCard testMilitaryCard2;
	Player player1;
	Player player2;
	
	@Before
	public void setUp() {
		attackTest = new AttackBoard();
		player1 = new Player(1);
		player2 = new Player(2);
		 
	}
	
	

	@Test
	public void testPosition() {
		
		assertEquals(0,attackTest.getPosition());
	}

	@Test
	public void testConstructor() {
		
		
		assertEquals(2, attackTest.getPosAndCoinLoss().get(1));
		assertEquals(2, attackTest.getPosAndCoinLoss().get(3));
		assertEquals(5, attackTest.getPosAndCoinLoss().get(6));
		assertEquals(2, attackTest.getPosAndCoinLoss().get(-1));
		assertEquals(2, attackTest.getPosAndCoinLoss().get(-3));
		assertEquals(5, attackTest.getPosAndCoinLoss().get(-6));
	}
	
	@Test
	public void testAttackTime() {
		testMilitaryCard =  new MilitaryCard("testMilitaryCard", new Cost(), 1, new ChainSymbols());
		attackTest.attackTime(player1, testMilitaryCard);
		assertEquals(1,attackTest.getPosition());
		testMilitaryCard2 =  new MilitaryCard("testMilitaryCard2", new Cost(), 8, new ChainSymbols());
		attackTest.attackTime(player2, testMilitaryCard2);
		assertEquals(-7,attackTest.getPosition());
		
		
		/* cannot check testRewardAndPun by attack  cause in class AttackBoard we did not summon method 
		 * RewardAndPun by local variable but we call it from GameController so in JUNIT i dont know how to
		 * call the variables from there T_________________T
		 */
		
	}
	
	@Test
	public void testRewardAndPun() {
		
		attackTest.setPosition(1);
		attackTest.rewardAndPun(player1, player2);
		assertEquals(2,player1.getplayerPoint());
		
		attackTest.setPosition(-1);
		attackTest.rewardAndPun(player1, player2);
		assertEquals(2,player2.getplayerPoint());
		
		attackTest.setPosition(3);
		attackTest.rewardAndPun(player1, player2);
		assertEquals(5,player2.getResourceCounter().getLMD());
		
		attackTest.setPosition(-3);
		attackTest.rewardAndPun(player1, player2);
		assertEquals(5,player1.getResourceCounter().getLMD());
		
		attackTest.setPosition(6);
		attackTest.rewardAndPun(player1, player2);
		assertEquals(0,player2.getResourceCounter().getLMD());
		
		attackTest.setPosition(-6);
		attackTest.rewardAndPun(player1, player2);
		assertEquals(0,player2.getResourceCounter().getLMD());
	}
	
	@Test
	public void testWinCondition() {
		
		assertFalse(attackTest.winConditionCheck(player1));
		attackTest.setPosition(9);
		assertTrue(attackTest.winConditionCheck(player1));
		attackTest.setPosition(-9);
		assertTrue(attackTest.winConditionCheck(player2));
		attackTest.setPosition(5);
		assertFalse(attackTest.winConditionCheck(player1));
		attackTest.setPosition(-3);
		assertFalse(attackTest.winConditionCheck(player2));
	}
	
	
	
}
