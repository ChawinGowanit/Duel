package Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import logic.AttackBoard;
import logic.MainBoard;
import logic.PlaceBoard;
import logic.Player;
import logic.Turn;

class TestTurn {
	Player p1 ;
	Player p2 ;
	MainBoard mainBoard ;
	AttackBoard attackBoard ;
	PlaceBoard placeBoard;
	Turn testTurn ;
	
	@BeforeEach
	protected void setUpBeforeEachTest() {
		p1 = new Player(1) ;
		p2 = new Player(2) ;
		placeBoard = new PlaceBoard() ;
		attackBoard = new AttackBoard() ;
		testTurn = new Turn() ;
		
	}
	@Test
	void testPickCard() {
		
	}
	@Test
	void testBuildUsingChainSymbol() {
		
	}
	@Test
	void testBuildUsingLMD() {
		
	}
	@Test
	void testBuildInsufficientMaterial() {
		
	}
	@Test
	void testCancelBuild() {
		
	}
	@Test
	void testSell() {
	
	}
	@Test
	void testSellAfterBuildTradingCard() {
		
	}
	@Test
	void testBuildPlace() {
		
	}
	@Test
	void testBuildPlaceUsingLMD() {
		
	}
	@Test
	void testCancelBuildPlace() {
		
	}
	
}
