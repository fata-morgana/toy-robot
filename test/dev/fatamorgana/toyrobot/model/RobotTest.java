package dev.fatamorgana.toyrobot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class RobotTest {
	private static final int INIT_X_POS = 1;
	private static final int INIT_Y_POS = 1;

	@Test
	public void testMoveOnNorth() {
		Robot testRobot = createTestingRobot(Direction.NORTH);
		testRobot.move();
		assertEquals(1, testRobot.getPositionX());
		assertEquals(2, testRobot.getPositionY());
		assertEquals(Direction.NORTH, testRobot.getDirection());
	}

	@Test
	public void testMoveOnEast() {
		Robot testRobot = createTestingRobot(Direction.EAST);
		testRobot.move();
		assertEquals(2, testRobot.getPositionX());
		assertEquals(1, testRobot.getPositionY());
		assertEquals(Direction.EAST, testRobot.getDirection());
	}

	@Test
	public void testMoveOnSouth() {
		Robot testRobot = createTestingRobot(Direction.SOUTH);
		testRobot.move();
		assertEquals(1, testRobot.getPositionX());
		assertEquals(0, testRobot.getPositionY());
		assertEquals(Direction.SOUTH, testRobot.getDirection());
	}

	@Test
	public void testMoveOnWest() {
		Robot testRobot = createTestingRobot(Direction.WEST);
		testRobot.move();
		assertEquals(0, testRobot.getPositionX());
		assertEquals(1, testRobot.getPositionY());
		assertEquals(Direction.WEST, testRobot.getDirection());
	}
	
	@Test
	public void testTurnLeft() {
		Robot testRobot = createTestingRobot(Direction.NORTH);
		testRobot.turnLeft();
		assertEquals(Direction.WEST, testRobot.getDirection());
		testRobot.turnLeft();
		assertEquals(Direction.SOUTH, testRobot.getDirection());
		testRobot.turnLeft();
		assertEquals(Direction.EAST, testRobot.getDirection());
		testRobot.turnLeft();
		assertEquals(Direction.NORTH, testRobot.getDirection());
	}
	
	@Test
	public void testTurnRight() {
		Robot testRobot = createTestingRobot(Direction.NORTH);
		testRobot.turnRight();
		assertEquals(Direction.EAST, testRobot.getDirection());
		testRobot.turnRight();
		assertEquals(Direction.SOUTH, testRobot.getDirection());
		testRobot.turnRight();
		assertEquals(Direction.WEST, testRobot.getDirection());
		testRobot.turnRight();
		assertEquals(Direction.NORTH, testRobot.getDirection());
	}
	
	Robot createTestingRobot(Direction direction) {
		return new Robot(INIT_X_POS, INIT_Y_POS, direction);
	}
}
