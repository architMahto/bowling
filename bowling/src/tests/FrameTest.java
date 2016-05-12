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
		strikeFrame = new Frame(10, 0, 0, 0);
		spareFrame = new Frame(3, 7, 0, 0);
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
	public void testGetFirstBall() {
		assertEquals("Frame is not a strike as expected", 10, strikeFrame.getFirstBall());
		assertEquals("Frame is not a spare as expected", 3, spareFrame.getFirstBall());
	}
	
	@Test
	public void testGetSecondBall() {
		assertEquals("Frame is not a strike as expected", 0, strikeFrame.getSecondBall());
		assertEquals("Frame is not a spare as expected", 7, spareFrame.getSecondBall());
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
