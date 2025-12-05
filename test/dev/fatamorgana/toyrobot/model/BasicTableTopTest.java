package dev.fatamorgana.toyrobot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class BasicTableTopTest {
	
	@Test
	public void testCreateWithDefaultDimention() {
		BasicTableTop tableTop = BasicTableTop.createDefault();
		assertEquals(0, tableTop.getLowerMost());
		assertEquals(0, tableTop.getLeftMost());
		assertEquals(4, tableTop.getUpperMost());
		assertEquals(4, tableTop.getRightMost());
	}

	@Test
	public void testCreateWithInvalidHeight() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> BasicTableTop.createWithDimension(-1, 0));
		assertEquals("Height must be positive.", ex.getMessage());
	}

	@Test
	public void testCreateWithInvalidWidth() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> BasicTableTop.createWithDimension(0, -1));
		assertEquals("Width must be positive.", ex.getMessage());
	}
	
	@Test
	public void testCreateWithCustomDimention() {
		BasicTableTop tableTop = BasicTableTop.createWithDimension(1, 2);
		assertEquals(0, tableTop.getLowerMost());
		assertEquals(0, tableTop.getLeftMost());
		assertEquals(0, tableTop.getUpperMost());
		assertEquals(1, tableTop.getRightMost());
	}
	
	@Test
	public void testIsValidPosition() {		
		final BasicTableTop defaultTableTop = BasicTableTop.createDefault();
		assertTrue(defaultTableTop.isValidPosition(0, 0));
		assertTrue(defaultTableTop.isValidPosition(4, 4));
		assertFalse(defaultTableTop.isValidPosition(-1, 0));
		assertFalse(defaultTableTop.isValidPosition(4, -1));
		assertFalse(defaultTableTop.isValidPosition(0, -1));
		assertFalse(defaultTableTop.isValidPosition(-1, 0));
	}
}
