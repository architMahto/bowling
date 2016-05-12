package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bowling.Game;
import bowling.Player;

public class GameTest {
	
	private List<Player> players;
	public Game game;

	@Before
	public void setUp() throws Exception {
		players = new ArrayList<Player>();
		players.add(new Player("Archit"));
		players.add(new Player("Kyle"));
		game = new Game(players);
	}

	@After
	public void tearDown() throws Exception {
		players = null;
		game = null;
	}

	@Test
	public void testConstructor() {
		Game emptyGame = null;
		assertNull("Game was not null as expected", emptyGame);
		assertNotNull("Game was not instantiated as expected", game);
	}

}
