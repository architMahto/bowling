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

}
