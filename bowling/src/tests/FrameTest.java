package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bowling.Frame;

public class FrameTest {
	
	private Frame strikeFrame;
	private int firstBallStrikeScore = 10;
	private int secondBallStrikeScore = 0;

	@Before
	public void setUp() throws Exception {
		strikeFrame = new Frame(true, false, 10, 0);
	}

	@After
	public void tearDown() throws Exception {
		strikeFrame = null;
	}

	@Test
	public void testConstructor() {
		Frame f1 = null;
		assertNull("Frame was not null as expected", f1);
		assertNotNull("Frame was not instantiated as expected", strikeFrame);
	}

	@Test
	public void testIsOnFirstBall() {
		assertTrue("Frame is on first roll", strikeFrame.isOnFirstBall());
	}
	
	@Test
	public void testIsOnSecondBall() {
		assertFalse("Frame is on second roll", strikeFrame.isOnSecondBall());
	}
	
	@Test
	public void testGetFirstBall() {
		assertEquals("Frame is not a strike as expected", strikeFrame.getFirstBall(), firstBallStrikeScore);
	}
	
	@Test
	public void testGetSecondBall() {
		assertEquals("Frame is not a strike as expected", strikeFrame.getSecondBall(), secondBallStrikeScore);
	}
}
