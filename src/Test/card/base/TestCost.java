package Test.card.base;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Card.base.Cost;
import logic.Player;

public class TestCost {
	@Test
	public void testConstructor() {
		Cost cost = new Cost();
		assertEquals(0, cost.getD32Steel());
		assertEquals(0, cost.getBipolarNanoflake());
		assertEquals(0, cost.getPolymerizationPreparation());
		assertEquals(0, cost.getSugarPack());
		assertEquals(0, cost.getManganeseOre());
		assertEquals(0, cost.getLMD());
		Cost cost1 = new Cost(1,2,3,4,5,6) ;
		assertEquals(1, cost1.getD32Steel());
		assertEquals(2, cost1.getBipolarNanoflake());
		assertEquals(3, cost1.getPolymerizationPreparation());
		assertEquals(4, cost1.getSugarPack());
		assertEquals(5, cost1.getManganeseOre());
		assertEquals(6, cost1.getLMD());
	}
	@Test
	public void testAddCost() {
		Cost cost1 = new Cost(1,2,3,4,5,6);
		Cost cost2 = new Cost(6,5,4,3,2,1);
		assertEquals(new Cost(7,7,7,7,7,7).toString(), Cost.addCost(cost1, cost2).toString());
		Cost cost3 = new Cost(-2,-2,-2,-2,-2,-2) ;
		assertEquals(new Cost(-1,0,1,2,3,4).toString(), Cost.addCost(cost1, cost3).toString());

	}
	@Test
	public void testReduceCost() {
		Cost cost1 = new Cost(1,2,3,4,5,6);
		Cost cost2 = new Cost(6,5,4,3,2,1);
		assertEquals(new Cost(0,0,0,1,3,5).toString(), Cost.reduceCost(cost1, cost2).toString());
	}
	@Test
	public void testCheckCost() {
		Player P1 = new Player(1) ;
		P1.setResourceCounter(new Cost(0,0,0,0,0,100));
		Cost cost = new Cost(1,1,1,1,1,1);
		assertEquals(false, Cost.checkCost(P1.getResourceCounter(), cost));
		P1.setResourceCounter(new Cost(1,1,1,1,1,1));
		assertEquals(true, Cost.checkCost(P1.getResourceCounter(), cost));
		P1.setResourceCounter(new Cost(2,2,2,2,2,2));
		assertEquals(true, Cost.checkCost(P1.getResourceCounter(), cost));
	}
	@Test 
	public void testCheckLMD() {
		Player P1 = new Player(1) ;
		P1.setResourceCounter(new Cost(0,0,0,0,0,100));
		Cost cost = new Cost(1,1,1,1,1,1);
		assertEquals(11, Cost.checkLmd(P1.getResourceCounter(), cost,P1.getbuyResourceCost()));
		P1.setResourceCounter(new Cost(0,0,0,0,0,0));
		assertEquals(1000, Cost.checkLmd(P1.getResourceCounter(), cost,P1.getbuyResourceCost()));
		P1.setResourceCounter(new Cost(1,0,1,0,1,1));
		assertEquals(5, Cost.checkLmd(P1.getResourceCounter(), cost,P1.getbuyResourceCost()));
		Cost cost1 = new Cost(1,1,1,1,1,0);
		P1.setResourceCounter(new Cost(1,1,1,1,0,0));
		assertEquals(2, Cost.checkLmd(P1.getResourceCounter(), cost1,P1.getbuyResourceCost()));

	}
}
