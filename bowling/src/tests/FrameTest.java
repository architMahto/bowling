package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bowling.Frame;

public class FrameTest {
	
	private Frame strikeFrame, spareFrame;

	@Before
	public void setUp() throws Exception {
		strikeFrame = new Frame(true, false, 10, 0);
		spareFrame = new Frame(false, true, 3, 7);
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
		assertTrue("Frame is not on first roll", strikeFrame.isOnFirstBall());
		assertFalse("Frame is on first roll", spareFrame.isOnFirstBall());
	}
	
	@Test
	public void testIsOnSecondBall() {
		assertFalse("Frame is on second roll", strikeFrame.isOnSecondBall());
		assertTrue("Frame is not on second roll", spareFrame.isOnSecondBall());
	}
	
	@Test
	public void testGetFirstBall() {
		assertEquals("Frame is not a strike as expected", strikeFrame.getFirstBall(), 10);
		assertEquals("Frame is not a spare as expected", spareFrame.getFirstBall(), 3);
	}
	
	@Test
	public void testGetSecondBall() {
		assertEquals("Frame is not a strike as expected", strikeFrame.getSecondBall(), 0);
		assertEquals("Frame is not a spare as expected", spareFrame.getSecondBall(), 7);
	}
	
	@Test
	public void testIsStrike() {
		assertTrue("Frame is not a strike", strikeFrame.isStrike());
	}
	
	@Test 
	public void testIsSpare() {
		assertTrue("Frame is not a spare", spareFrame.isSpare());
	}
	
	@Test
	public void testScore() {
		assertEquals("Score is not as expected", strikeFrame.score(), 10);
		assertEquals("Score is not as expected", spareFrame.score(), 10);
	}
}
