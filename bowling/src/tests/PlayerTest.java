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
	}

//	@Test
//	public void testConstructor() {
//		Player nullPlayer = null;
//		assertNull("Player was not null as expected", nullPlayer);
//		assertNotNull("Player was not instantiated as expected", player);
//	}
//	
//	@Test
//	public void testGetName() {
//		assertEquals("Player has wrong name", player.getName(), "archit");
//	}
//	
//	@Test
//	public void testGetScore() {
//		assertEquals("Player has wrong score", player.getScore(), 0);
//	}

	@Test
	public void testRoll() {
		player.roll(10,0);
		assertEquals("Frame has not been added", player.frames.size(), 1);
	}
	
	public void testUpdateScoreForZeroGame() {
		player.roll(0,0);
		player.roll(0,0);
		player.roll(0,0);
		player.roll(0,0);
		player.roll(0,0);
		player.roll(0,0);
		player.roll(0,0);
		player.roll(0,0);
		player.roll(0,0);
		player.roll(0,0);
		assertEquals("Score is not correct", 0, player.updateScores());
	}
	
	@Test
	public void testUpdateScoreForRegularGame() {
		
		player.roll(1,5);
		player.roll(3,6);
		player.roll(7,2);
		player.roll(3,6);
		player.roll(4,4);
		player.roll(5,3);
		player.roll(3,3);
		player.roll(4,5);
		player.roll(8,1);
		player.roll(2,6);
		assertEquals("Score is not correct", 81, player.updateScores());
	}
}
