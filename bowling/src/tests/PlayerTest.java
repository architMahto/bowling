package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bowling.Player;

public class PlayerTest {
	
	private Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player("archit");
	}

	@After
	public void tearDown() throws Exception {
		player = null;
	}

	@Test
	public void testConstructor() {
		Player nullPlayer = null;
		assertNull("Player was not null as expected", nullPlayer);
		assertNotNull("Player was not instantiated as expected", player);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Player has wrong name", player.getName(), "archit");
	}
	
	@Test
	public void testGetScore() {
		assertEquals("Player has wrong score", player.getScore(), 0);
	}

	@Test
	public void testRoll() {
		player.roll(10,0,0,0);
		assertEquals("Frame has not been added", player.frames.size(), 1);
	}
	
	public void testUpdateScoreForZeroGame() {
		player.roll(0,0,0,0);
		player.roll(0,0,0,1);
		player.roll(0,0,0,2);
		player.roll(0,0,0,3);
		player.roll(0,0,0,4);
		player.roll(0,0,0,5);
		player.roll(0,0,0,6);
		player.roll(0,0,0,7);
		player.roll(0,0,0,8);
		player.roll(0,0,0,9);
		assertEquals("Score is not correct", 0, player.updateScores());
	}
	
	@Test
	public void testUpdateScoreForGameWithNoStrikesAndNoSpares() {
		
		player.roll(1,5,0,0);
		player.roll(3,6,0,1);
		player.roll(7,2,0,2);
		player.roll(3,6,0,3);
		player.roll(4,4,0,4);
		player.roll(5,3,0,5);
		player.roll(3,3,0,6);
		player.roll(4,5,0,7);
		player.roll(8,1,0,8);
		player.roll(2,6,0,9);
		assertEquals("Score is not correct", 81, player.updateScores());
	}
	
	@Test
	public void testUpdateScoreWithSingleStrikeFirst() {
		
		player.roll(10,0,0,0);
		player.roll(3,6,0,1);
		player.roll(7,2,0,2);
		player.roll(3,6,0,3);
		player.roll(4,4,0,4);
		player.roll(5,3,0,5);
		player.roll(3,3,0,6);
		player.roll(4,5,0,7);
		player.roll(8,1,0,8);
		player.roll(2,6,0,9);
		assertEquals("Score is not correct", 94, player.updateScores());
	}
	
	@Test
	public void testUpdateScoreWithSingleStrikeLast() {
		
		player.roll(1,5,0,0);
		player.roll(3,6,0,1);
		player.roll(7,2,0,2);
		player.roll(3,6,0,3);
		player.roll(4,4,0,4);
		player.roll(5,3,0,5);
		player.roll(3,3,0,6);
		player.roll(4,5,0,7);
		player.roll(8,1,0,8);
		player.roll(10,0,0,9);
		assertEquals("Score is not correct", 83, player.updateScores());
	}
	
	@Test
	public void testUpdateScoreWithSingleSpareFirst() {
		
		player.roll(1,9,0,0);
		player.roll(3,6,0,1);
		player.roll(7,2,0,2);
		player.roll(3,6,0,3);
		player.roll(4,4,0,4);
		player.roll(5,3,0,5);
		player.roll(3,3,0,6);
		player.roll(4,5,0,7);
		player.roll(8,1,0,8);
		player.roll(2,6,0,9);
		assertEquals("Score is not correct", 88, player.updateScores());
	}
	
	@Test
	public void testUpdateScoreWithSingleSpareLast() {
		
		player.roll(1,5,0,0);
		player.roll(3,6,0,1);
		player.roll(7,2,0,2);
		player.roll(3,6,0,3);
		player.roll(4,4,0,4);
		player.roll(5,3,0,5);
		player.roll(3,3,0,6);
		player.roll(4,5,0,7);
		player.roll(8,1,0,8);
		player.roll(9,1,0,9);
		assertEquals("Score is not correct", 83, player.updateScores());
	}
	
	@Test
	public void testUpdateScoreWithStrikesAndSpares() {
		
		player.roll(10,0,0,0);
		player.roll(7,3,0,1);
		player.roll(9,0,0,2);
		player.roll(10,0,0,3);
		player.roll(0,8,0,4);
		player.roll(8,2,0,5);
		player.roll(0,6,0,6);
		player.roll(10,0,0,7);
		player.roll(10,0,0,8);
		player.roll(10,8,1,9);
		assertEquals("Score is not correct", 167, player.updateScores());
	}
	
	@Test 
	public void testUpdateScoreWithPerfectGame() {
		
		player.roll(10,0,0,0);
		player.roll(10,0,0,1);
		player.roll(10,0,0,2);
		player.roll(10,0,0,3);
		player.roll(10,0,0,4);
		player.roll(10,0,0,5);
		player.roll(10,0,0,6);
		player.roll(10,0,0,7);
		player.roll(10,0,0,8);
		player.roll(10,10,10,9);
		assertEquals("Score is not correct", 300, player.updateScores());
	}
}

